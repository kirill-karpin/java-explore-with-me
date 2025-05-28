package ru.practicum.ewmmainservice.core.compilation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.compilation.Compilation;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;

/**
 * DTO for {@link Compilation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompilationDto {

  Long id;
  @NotNull
  private Boolean pinned;
  @NotNull
  @Size(max = 50)
  private String title;
  private Set<EventDto> events;
}
