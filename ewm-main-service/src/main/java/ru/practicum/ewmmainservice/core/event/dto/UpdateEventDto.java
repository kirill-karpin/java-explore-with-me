package ru.practicum.ewmmainservice.core.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.event.EventState;
import ru.practicum.ewmmainservice.core.event.EventStateAction;

/**
 * DTO for {@link ru.practicum.ewmmainservice.core.event.Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventDto {

  Long id;
  @Nullable
  @Size(max = 2000, min = 20)
  private String annotation;
  private Integer confirmedRequests;
  @Nullable
  private Instant createdOn;
  private Instant publishedOn;
  @Nullable
  @Size(max = 7000, min = 20)
  private String description;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  @Nullable
  @Future
  private Instant eventDate;

  @Nullable
  private Boolean paid;
  @Positive
  private Integer participantLimit;
  @Nullable
  private EventState state;
  private Boolean requestModeration;
  @Nullable
  @Size(max = 120, min = 3)
  private String title;
  @Nullable
  private LocationDto location;
  private EventStateAction stateAction;
}
