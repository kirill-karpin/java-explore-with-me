package ru.practicum.ewmmainservice.core.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.event.Event;

/**
 * DTO for {@link Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDto implements Serializable {

  @NotNull
  @Size(max = 2000)
  String annotation;
  @NotNull
  Long category;
  @NotNull
  @Size(max = 7000)
  String description;
  @NotNull
  Instant eventDate;
  @NotNull
  LocationDto location;
  @NotNull
  @Size(max = 120)
  String title;
  @NotNull
  Boolean paid;
  Integer participantLimit;
  Boolean requestModeration;
}

