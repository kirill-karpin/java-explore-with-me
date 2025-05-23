package ru.practicum.ewmmainservice.core.category.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Builder;
import lombok.Value;
import ru.practicum.ewmmainservice.core.category.Category;

/**
 * DTO for {@link Category}
 */
@Builder
@Value
public class CategoryDto implements Serializable {

  Long id;
  @NotNull
  @Size(max = 50)
  String name;
}
