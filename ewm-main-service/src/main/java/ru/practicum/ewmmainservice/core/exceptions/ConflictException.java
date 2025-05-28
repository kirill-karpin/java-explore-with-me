package ru.practicum.ewmmainservice.core.exceptions;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException {

  private final String reason;

  public ConflictException(String reason, String message) {
    super(message);
    this.reason = reason;
  }

}
