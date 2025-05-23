package ru.practicum.ewmmainservice.core.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Value;

@Value
public class ErrorResponse {

  String status;
  String reason;
  String message;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime timestamp = LocalDateTime.now();
}
