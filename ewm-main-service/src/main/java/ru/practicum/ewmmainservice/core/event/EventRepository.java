package ru.practicum.ewmmainservice.core.event;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.practicum.ewmmainservice.core.user.User;

public interface EventRepository extends JpaRepository<Event, Long>,
    JpaSpecificationExecutor<Event> {


  Optional<Event> findByIdAndInitiatorid(Long eventId, User initiatorId);
}
