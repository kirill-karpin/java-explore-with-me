package ru.practicum.ewmmainservice.core.rating;

import java.util.List;

public interface RatingLikesService {

  List<RatingLikes> getTop10EventsByLikesAllTime();
}
