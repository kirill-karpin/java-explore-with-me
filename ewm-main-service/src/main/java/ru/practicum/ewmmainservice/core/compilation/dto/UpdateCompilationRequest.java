package ru.practicum.ewmmainservice.core.compilation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;
import lombok.Value;
import ru.practicum.ewmmainservice.core.compilation.Compilation;

/**
 * DTO for {@link Compilation}
 */
@Data
public class UpdateCompilationRequest  {

  Long id;
  @NotNull
  Boolean pinned;
  @NotNull
  @Size(max = 50)
  String title;
}
