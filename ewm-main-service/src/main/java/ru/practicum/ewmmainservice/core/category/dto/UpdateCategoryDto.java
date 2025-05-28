package ru.practicum.ewmmainservice.core.category.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {

  private Integer id;
  @NotEmpty
  @Size(max = 50)
  private String name;
}
