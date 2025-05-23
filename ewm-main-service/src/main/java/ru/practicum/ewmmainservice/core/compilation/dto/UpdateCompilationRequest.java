package ru.practicum.ewmmainservice.core.compilation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class UpdateCompilationRequest {

  Long id;
  @NotNull
  Boolean pinned;
  @NotNull
  @Size(max = 50)
  String title;
}
