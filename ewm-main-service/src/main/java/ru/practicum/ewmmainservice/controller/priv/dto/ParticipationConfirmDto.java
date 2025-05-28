package ru.practicum.ewmmainservice.controller.priv.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationConfirmDto {

  private List<Long> requestIds;
  private ParticipationRequestStatus status;
}
