package ru.practicum.ewmmainservice.core.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

  private String status;
  private String reason;
  private String message;

  public ErrorResponse(String status, String reason, String message) {
    this.status = status;
    this.reason = reason;
    this.message = message;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timestamp = LocalDateTime.now();
}
