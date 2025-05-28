package ru.practicum.ewmmainservice.core.compilation.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompilationDto {

  private Long id;
  @Nullable
  private Boolean pinned;
  @Nullable
  @Size(max = 50)
  private String title;
  private Set<Integer> events;
}
