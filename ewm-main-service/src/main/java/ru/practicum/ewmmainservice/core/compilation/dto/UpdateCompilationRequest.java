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
public class UpdateCompilationRequest {

  Long id;
  @Nullable
  Boolean pinned;
  @Nullable
  @Size(max = 50)
  String title;
  Set<Integer> events = Set.of();
}
