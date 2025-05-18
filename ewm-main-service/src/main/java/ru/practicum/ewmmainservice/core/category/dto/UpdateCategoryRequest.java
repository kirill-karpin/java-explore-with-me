package ru.practicum.ewmmainservice.core.category.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateCategoryRequest {

  private Integer id;
  @NotEmpty
  private String name;
}
