package ru.practicum.ewmmainservice.core.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
public class CreateUserRequest {

  @Size(max = 250)
  @NotNull
  String name;

  @NotNull
  String email;
}
