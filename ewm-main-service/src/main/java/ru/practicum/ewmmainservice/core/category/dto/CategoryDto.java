package ru.practicum.ewmmainservice.core.category.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.category.Category;

/**
 * DTO for {@link Category}
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {

  private Long id;
  @NotNull
  private @Size(max = 50)
  String name;
}
