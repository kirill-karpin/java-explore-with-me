package ru.practicum.ewmmainservice.core.participation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import lombok.Value;

/**
 * DTO for {@link ParticipationRequest}
 */
@Value
public class ParticipationRequestDto implements Serializable {

  Long id;
  @NotNull
  Long eventid;
  @NotNull
  Long requesterid;
  @NotNull
  Instant created;
  @NotNull
  @Size(max = 50)
  String status;
}
