package ru.practicum.ewmmainservice.core.participation;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  Long event;
  @NotNull
  Long requester;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  Instant created;
  @NotNull
  @Size(max = 50)
  String status;
}
