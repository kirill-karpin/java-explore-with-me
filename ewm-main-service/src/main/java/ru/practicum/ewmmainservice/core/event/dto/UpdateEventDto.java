package ru.practicum.ewmmainservice.core.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
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
  @Size(max = 2000)
  String annotation;
  Integer confirmedRequests;
  @Nullable
  Instant createdOn;
  Instant publishedOn;
  @Nullable
  @Size(max = 7000)
  String description;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  @Nullable
  Instant eventDate;

  @Nullable
  Boolean paid;
  Integer participantLimit;
  @Nullable
  EventState state;
  Boolean requestModeration;
  @Nullable
  @Size(max = 120)
  String title;
  @Nullable
  LocationDto location;
  EventStateAction stateAction;
}
