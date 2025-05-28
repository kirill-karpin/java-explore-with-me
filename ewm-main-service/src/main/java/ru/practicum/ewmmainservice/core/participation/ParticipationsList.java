package ru.practicum.ewmmainservice.core.participation;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationsList {

  private List<ParticipationRequestDto> rejectedRequests = new ArrayList<>();
  private List<ParticipationRequestDto> confirmedRequests = new ArrayList<>();
  private List<ParticipationRequestDto> pendingRequests = new ArrayList<>();

}
