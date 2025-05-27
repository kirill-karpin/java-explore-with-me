package ru.practicum.ewmmainservice.core.participation;

import java.util.List;

public interface ParticipationRequestService {

  ParticipationRequestDto create(Long userId, Long eventId);

  ParticipationRequestDto cancel(Long userId, Long requestId);

  List<ParticipationRequestDto> getAllByUserId(Long userId);
}
