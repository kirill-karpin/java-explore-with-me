package ru.practicum.ewmmainservice.core.like.service;

import java.util.List;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.like.dto.CreateLikeDto;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;

public interface LikeService {

  LikeDto likeEntity(CreateLikeDto createLikeRequest);

  void deleteLike(Long userId, Long likeId);

  List<LikeDto> getUserLikes(Long userId, Paging paging);
}
