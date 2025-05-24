package ru.practicum.ewmmainservice.core.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;
import ru.practicum.ewmmainservice.core.event.Event;
import ru.practicum.ewmmainservice.core.user.dto.UserDto;

/**
 * DTO for {@link Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
  LocationDto location;
  CategoryDto category;
  UserDto initiator;
}
