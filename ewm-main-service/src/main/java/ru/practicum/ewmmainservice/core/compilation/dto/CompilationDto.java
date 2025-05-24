package ru.practicum.ewmmainservice.core.compilation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
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
public class CompilationDto implements Serializable {

  Long id;
  @NotNull
  Boolean pinned;
  @NotNull
  @Size(max = 50)
  String title;
  Set<EventDto> events;
}
