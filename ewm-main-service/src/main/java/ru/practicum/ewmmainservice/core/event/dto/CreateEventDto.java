package ru.practicum.ewmmainservice.core.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class CreateEventDto {

  @NotNull
  @NotEmpty
  @NotBlank
  @Size(max = 2000, min = 20)
  String annotation;
  @NotNull
  Long category;
  @NotEmpty
  @NotBlank
  @Size(max = 7000, min = 20)
  String description;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  @Future
  Instant eventDate;
  @NotNull
  LocationDto location;
  @NotNull
  @Size(max = 120, min = 3)
  String title;
  @Nullable
  Boolean paid = false;
  @Min(0)
  @Nullable
  Integer participantLimit = 0;
  @Nullable
  Boolean requestModeration = true;
}

