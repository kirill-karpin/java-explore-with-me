package ru.practicum.ewmmainservice.core.rating;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.like.EntityTypeEnum;

@Service
@RequiredArgsConstructor
class RatingLikesServiceImpl implements RatingLikesService {

  private final RatingLikesRepository ratingLikesRepository;

  @Override
  public List<RatingLikes> getTop10EventsByLikesAllTime() {
    Pageable pageable = PageRequest.of(0, 10);
    return ratingLikesRepository.getAllByEntityTypeOrderByTotalDesc(EntityTypeEnum.EVENT.name(),
        pageable);
  }

}
