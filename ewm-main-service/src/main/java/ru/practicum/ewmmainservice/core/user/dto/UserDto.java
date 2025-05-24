package ru.practicum.ewmmainservice.core.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import ru.practicum.ewmmainservice.core.user.User;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
public class UserDto implements Serializable {

  Long id;

  @Size(max = 250)
  @NotNull
  String name;

  @NotNull
  String email;
}
