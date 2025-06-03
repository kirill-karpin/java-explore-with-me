package ru.practicum.ewmmainservice.core.like.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.event.EventRepository;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;
import ru.practicum.ewmmainservice.core.like.Like;
import ru.practicum.ewmmainservice.core.like.LikeRepository;
import ru.practicum.ewmmainservice.core.like.dto.CreateLikeDto;
import ru.practicum.ewmmainservice.core.like.dto.EntityData;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;

@Service
@RequiredArgsConstructor
class LikeServiceImpl implements LikeService {

  private final LikeRepository likeRepository;
  private final LikeMapper likeMapper;
  private final EventRepository eventRepository;

  @Override
  public LikeDto likeEntity(CreateLikeDto createLikeRequest) {
    Like like = likeMapper.toEntity(createLikeRequest);
    return likeMapper.toDto(likeRepository.save(like));
  }

  @Override
  public void deleteLike(Long userId, Long likeId) {

    likeRepository.findById(likeId).orElseThrow(() -> new NotFoundException("like not found"));

    likeRepository.deleteById(likeId);
  }

  @Override
  public List<LikeDto> getUserLikes(Long userId, Paging paging) {
    List<LikeDto> likes = likeRepository.getAllByUserId(userId, paging.toPageable())
        .stream().map(likeMapper::toDto).toList();
    if (!likes.isEmpty()) {
      for (LikeDto like : likes) {
        switch (like.getEntityType()) {
          case EVENT:
            eventRepository.findById(like.getEntityId())
                .ifPresent((event) -> {
                  EntityData entityData = new EntityData(
                      event.getId(),
                      event.getTitle()
                  );
                  like.setEntity(entityData);
                });
          default:
            break;
        }
      }
    }
    return likes;
  }
}
