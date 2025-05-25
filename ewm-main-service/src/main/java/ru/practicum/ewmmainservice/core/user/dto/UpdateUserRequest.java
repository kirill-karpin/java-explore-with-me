package ru.practicum.ewmmainservice.core.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserRequest {

  Long id;

  @Size(max = 250)
  @NotNull
  String name;

  @NotNull
  String email;


}
