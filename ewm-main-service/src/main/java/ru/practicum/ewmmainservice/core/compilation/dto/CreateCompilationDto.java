package ru.practicum.ewmmainservice.core.compilation.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompilationDto {

  @Nullable
  private Boolean pinned = false;
  @NotNull
  @NotBlank
  @Size(max = 50)
  private String title;
  private Set<Integer> events = Set.of();
}
