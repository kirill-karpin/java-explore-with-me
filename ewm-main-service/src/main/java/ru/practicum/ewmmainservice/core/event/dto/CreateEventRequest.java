package ru.practicum.ewmmainservice.core.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import lombok.Value;
import ru.practicum.ewmmainservice.core.event.Event;

/**
 * DTO for {@link Event}
 */
@Value
public class CreateEventRequest implements Serializable {

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
  @Size(max = 50)
  String state;
  Boolean requestModeration;
  @NotNull
  @Size(max = 120)
  String title;
  @NotNull
  Double lat;
  @NotNull
  Double lon;
}
