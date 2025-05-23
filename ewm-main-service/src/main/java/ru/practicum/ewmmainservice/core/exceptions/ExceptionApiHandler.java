package ru.practicum.ewmmainservice.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleNotFound(final NotFoundException e) {
    return new ErrorResponse("NOT_FOUND", e.getMessage(), "");
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleValidation(final ValidationException e) {
    return new ErrorResponse("BAD_REQUEST", e.getMessage(), "");
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleRunTime(final RuntimeException e) {
    return new ErrorResponse("INTERNAL_SERVER_ERROR", e.getMessage(), "");
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleRunTime(final ConflictException e) {
    return new ErrorResponse(HttpStatus.CONFLICT.name(),
        e.getReason(),
        e.getMessage()
    );
  }
}
