package ru.practicum.ewmmainservice.core.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import lombok.Value;
import ru.practicum.ewmmainservice.core.event.EventState;

/**
 * DTO for {@link ru.practicum.ewmmainservice.core.event.Event}
 */
@Value
public class UpdateEventRequest implements Serializable {

  Long id;
  @NotNull
  @Size(max = 2000)
  String annotation;
  Integer confirmedRequests;
  @NotNull
  Instant createdOn;
  Instant publishedOn;
  @NotNull
  @Size(max = 7000)
  String description;
  @NotNull
  Instant eventDate;
  @NotNull
  Boolean paid;
  Integer participantLimit;
  @NotNull
  EventState state;
  Boolean requestModeration;
  @NotNull
  @Size(max = 120)
  String title;
  @NotNull
  LocationDto location;
}
