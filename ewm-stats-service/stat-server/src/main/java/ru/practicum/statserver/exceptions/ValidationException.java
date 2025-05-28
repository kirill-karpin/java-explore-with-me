package ru.practicum.statserver.exceptions;

public class ValidationException extends RuntimeException {

  public ValidationException(String message) {
    super(message);
  }
}
