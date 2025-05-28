package ru.practicum.ewmmainservice.core.participation;

import java.util.List;
import ru.practicum.ewmmainservice.controller.priv.dto.ParticipationConfirmDto;

public interface ParticipationRequestService {

  ParticipationRequestDto create(Long userId, Long eventId);

  ParticipationRequestDto cancel(Long userId, Long requestId);

  List<ParticipationRequestDto> getAllByUserId(Long userId);

  ParticipationsList confirmUserEventRequests(Long userId, Long eventId,
      ParticipationConfirmDto request);
}
