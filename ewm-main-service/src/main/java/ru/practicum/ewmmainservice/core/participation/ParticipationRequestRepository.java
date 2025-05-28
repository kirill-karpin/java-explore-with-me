package ru.practicum.ewmmainservice.core.participation;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Long> {

  ParticipationRequest findByIdAndRequesteridId(Long requestId, Long userId);

  List<ParticipationRequest> findAllByRequesterid_Id(Long userId);

  List<ParticipationRequest> getAllByEventid_Id(Long eventId);

  List<ParticipationRequest> findAllByIdIn(Collection<Long> ids);

  Collection<ParticipationRequest> findByEventid_Id(Long eventidId);
}
