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
  private String annotation;
  @NotNull
  private Long category;
  @NotEmpty
  @NotBlank
  @Size(max = 7000, min = 20)
  private String description;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  @Future
  private Instant eventDate;
  @NotNull
  private LocationDto location;
  @NotNull
  @Size(max = 120, min = 3)
  private String title;
  @Nullable
  private Boolean paid = false;
  @Min(0)
  @Nullable
  private Integer participantLimit = 0;
  @Nullable
  private Boolean requestModeration = true;
}

