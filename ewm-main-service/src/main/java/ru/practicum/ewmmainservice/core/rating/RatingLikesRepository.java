package ru.practicum.ewmmainservice.core.rating;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RatingLikesRepository extends JpaRepository<RatingLikes, Long>,
    JpaSpecificationExecutor<RatingLikes> {

  List<RatingLikes> getAllByEntityType(String entityTypeEnum, Pageable pageable);
}
