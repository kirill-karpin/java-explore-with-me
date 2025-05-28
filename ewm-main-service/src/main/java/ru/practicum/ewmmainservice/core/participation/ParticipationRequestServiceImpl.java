package ru.practicum.ewmmainservice.core.participation;

import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewmmainservice.controller.priv.dto.ParticipationConfirmDto;
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

  private final EntityManager entityManager;
  private final ParticipationRequestMapper mapper;
  private final UserRepository userRepository;
  private final EventRepository eventRepository;
  private final ParticipationRequestRepository participationRequestRepository;

  @Override
  public ParticipationRequestDto create(Long userId, Long eventId) {
    User userFromDb = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    Event eventFromDb = eventRepository.findById(eventId)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (!eventFromDb.getState().equals(EventState.PUBLISHED.name())) {
      throw new ConflictException("Integrity constraint has been violated",
          "Event with id= " + eventId + " is not published");
    }

    if (eventFromDb.getInitiatorid().getId().equals(userId)) {
      throw new ConflictException(
          "Нельзя отправить заявку на участие в событие, в котором вы не являетесь инициатором",
          "Event with id= " + eventId);
    }

    if (eventFromDb.getParticipantLimit() > 0
        && eventFromDb.getConfirmedRequests().equals(eventFromDb.getParticipantLimit())) {
      throw new ConflictException("Достигнут лимит участников", "Event with id= " + eventId);
    }

    ParticipationRequest participationRequest = new ParticipationRequest();
    participationRequest.setRequesterid(userFromDb);
    participationRequest.setEventid(eventFromDb);
    participationRequest.setCreated(Instant.now());
    if (eventFromDb.getParticipantLimit() == 0 || !eventFromDb.getRequestModeration()) {
      participationRequest.setStatus(ParticipationRequestStatus.CONFIRMED);
    } else {
      participationRequest.setStatus(ParticipationRequestStatus.PENDING);
    }

    try {

      ParticipationRequest participationRequestSaved = participationRequestRepository.save(
          participationRequest);

      return mapper.toDto(participationRequestSaved);
    } catch (Exception e) {
      throw new ConflictException("Integrity constraint has been violated", e.getMessage());
    }
  }

  @Override
  public ParticipationRequestDto cancel(Long userId, Long requestId) {
    ParticipationRequest participationRequest = participationRequestRepository.findByIdAndRequesteridId(
        requestId, userId);

    participationRequest.setStatus(ParticipationRequestStatus.CANCELED);

    return mapper.toDto(participationRequestRepository.save(participationRequest));
  }

  @Override
  public List<ParticipationRequestDto> getAllByUserId(Long userId) {
    return participationRequestRepository.findAllByRequesterid_Id(userId).stream()
        .map(mapper::toDto).toList();
  }

  @Override
  @Transactional
  public ParticipationsList confirmUserEventRequests(Long userId, Long eventId,
      ParticipationConfirmDto request) {

    eventRepository.findByInitiatorid_IdAndId(userId, eventId)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    List<ParticipationRequest> confirmRequests = participationRequestRepository.findAllByIdIn(
        request.getRequestIds()).stream().peek(p -> {

      if (p.getStatus().equals(ParticipationRequestStatus.CONFIRMED)) {
        throw new ConflictException("Нельзя отменить уже принятую заявку на участие в событии", "");
      }
      p.setStatus(request.getStatus());
    }).toList();

    participationRequestRepository.saveAll(confirmRequests);
    ParticipationsList participationsList = new ParticipationsList();

    participationRequestRepository.findByEventid_Id(eventId).stream()
        .forEach(p -> {
          if (p.getStatus().equals(ParticipationRequestStatus.CONFIRMED)) {
            participationsList.getConfirmedRequests().add(mapper.toDto(p));
          } else if (p.getStatus().equals(ParticipationRequestStatus.PENDING)) {
            participationsList.getPendingRequests().add(mapper.toDto(p));
          } else if (p.getStatus().equals(ParticipationRequestStatus.REJECTED)) {
            participationsList.getRejectedRequests().add(mapper.toDto(p));
          }
        });

    Event eventSaved = eventRepository.findById(eventId)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (eventSaved.getConfirmedRequests().equals(eventSaved.getParticipantLimit())) {
      throw new ConflictException("Достигнут лимит участников", "");
    }

    return participationsList;
  }
}
