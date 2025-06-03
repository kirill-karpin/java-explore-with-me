package ru.practicum.ewmmainservice.core.like;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LikeRepository extends JpaRepository<Like, Long>, JpaSpecificationExecutor<Like> {

  List<Like> getAllByUserId(Long userId, Pageable pageable);
}
