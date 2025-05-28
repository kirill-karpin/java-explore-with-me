package ru.practicum.ewmmainservice.core.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.practicum.ewmmainservice.core.user.User;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
public class UserDto implements Serializable {

  private Long id;

  @Size(max = 250)
  @NotNull
  private String name;

  @NotNull
  private String email;
}
