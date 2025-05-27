package ru.practicum.ewmmainservice.core.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserDto {

  @Size(max = 250, min = 2)
  @NotEmpty
  @NotBlank
  String name;

  @NotEmpty
  @Email
  @Size(max = 254, min = 6)
  String email;
}
