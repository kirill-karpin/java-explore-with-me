package ru.practicum.ewmmainservice.core.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class EventDto {

  Long id;
  @NotNull
  @Size(max = 2000)
  private String annotation;
  private Integer confirmedRequests;
  @NotNull
  private Instant createdOn;
  private Instant publishedOn;
  @NotNull
  @Size(max = 7000)
  private String description;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Instant eventDate;
  @NotNull
  private Boolean paid;
  private Integer participantLimit;
  @NotNull
  @Size(max = 50)
  private String state;
  private Boolean requestModeration;
  @NotNull
  @Size(max = 120)
  private String title;
  @NotNull
  private LocationDto location;
  private CategoryDto category;
  private UserDto initiator;
  private Long views;
  private Integer rating;

}
