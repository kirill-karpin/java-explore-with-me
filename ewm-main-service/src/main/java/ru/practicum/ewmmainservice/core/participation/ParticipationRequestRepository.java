package ru.practicum.ewmmainservice.core.participation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Long> {

  ParticipationRequest findByIdAndRequesteridId(Long requestId, Long userId);
}
