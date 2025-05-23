package ru.practicum.ewmmainservice.core.participation;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.event.Event;
import ru.practicum.ewmmainservice.core.event.EventRepository;
import ru.practicum.ewmmainservice.core.event.EventState;
import ru.practicum.ewmmainservice.core.exceptions.ConflictException;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;
import ru.practicum.ewmmainservice.core.user.User;
import ru.practicum.ewmmainservice.core.user.UserRepository;

@RequiredArgsConstructor
@Service
class ParticipationRequestServiceImpl implements ParticipationRequestService {

  private final ParticipationRequestMapper participationRequestMapper;
  private final UserRepository userRepository;
  private final EventRepository eventRepository;
  private final ParticipationRequestRepository participationRequestRepository;

  @Override
  public ParticipationRequestDto create(Long userId, Long eventId) {
    User userFromDb = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    Event eventFromDb = eventRepository.findById(eventId)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (eventFromDb.getState() != EventState.PUBLISHED) {
      throw new ConflictException("Integrity constraint has been violated",
          "Event with id= " + eventId + " is not published");
    }

    ParticipationRequest participationRequest = new ParticipationRequest();
    participationRequest.setRequesterid(userFromDb);
    participationRequest.setEventid(eventFromDb);
    participationRequest.setCreated(Instant.now());
    participationRequest.setStatus(ParticipationRequestStatus.PENDING);

    try {
      return participationRequestMapper.toDto(
          participationRequestRepository.save(participationRequest)
      );
    } catch (Exception e) {
      throw new ConflictException("Integrity constraint has been violated", e.getMessage());
    }
  }

  @Override
  public ParticipationRequestDto cancel(Long userId, Long requestId) {
    ParticipationRequest participationRequest = participationRequestRepository
        .findByIdAndRequesteridId(requestId, userId);

    participationRequest.setStatus(ParticipationRequestStatus.CANCELED);

    return participationRequestMapper.toDto(
        participationRequestRepository.save(participationRequest));
  }
}
