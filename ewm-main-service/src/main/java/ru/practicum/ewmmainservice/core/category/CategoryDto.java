package ru.practicum.ewmmainservice.core.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Builder;
import lombok.Value;

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
