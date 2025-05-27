package ru.practicum.ewmmainservice.core.event;


import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewmmainservice.core.user.User;

public interface EventRepository extends JpaRepository<Event, Long>,
    JpaSpecificationExecutor<Event> {


  Optional<Event> findByIdAndInitiatorid(Long eventId, User initiatorId);

  List<Event> findAllByInitiatorid(User user, Pageable pageable);

  Optional<Event> findByInitiatorid_IdAndId(Long userId, Long eventId);

  @Modifying
  @Transactional
  @Query("UPDATE Event e SET e.views = :views WHERE e.id = :eventId")
  void incrementViews(Long eventId, Long views);
}
