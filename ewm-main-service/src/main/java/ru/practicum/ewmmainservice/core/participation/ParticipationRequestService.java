package ru.practicum.ewmmainservice.core.participation;

public interface ParticipationRequestService {

  ParticipationRequestDto create(Long userId, Long eventId);

  ParticipationRequestDto cancel(Long userId, Long requestId);
}
