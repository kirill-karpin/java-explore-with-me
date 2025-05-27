package ru.practicum.ewmmainservice.core.event.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import org.springframework.beans.BeanWrapperImpl;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

  private String startField;
  private String endField;

  @Override
  public void initialize(DateRange constraint) {
    this.startField = constraint.start();
    this.endField = constraint.end();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    try {
      LocalDateTime start = (LocalDateTime) new BeanWrapperImpl(value)
          .getPropertyValue(startField);
      LocalDateTime end = (LocalDateTime) new BeanWrapperImpl(value)
          .getPropertyValue(endField);

      if (start == null || end == null) {
        return true; // или false, если нужно требовать обе даты
      }

      return start.isBefore(end);
    } catch (Exception e) {
      return false;
    }
  }
}
