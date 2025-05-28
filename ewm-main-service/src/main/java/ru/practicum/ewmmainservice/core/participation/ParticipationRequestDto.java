package ru.practicum.ewmmainservice.core.participation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link ParticipationRequest}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationRequestDto implements Serializable {

  private Long id;
  @NotNull
  private Long event;
  @NotNull
  private Long requester;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  private Instant created;
  @NotNull
  @Size(max = 50)
  private String status;
}
