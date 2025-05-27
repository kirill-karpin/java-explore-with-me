package ru.practicum.ewmmainservice.core.event.service;

import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@DateRange(start = "rangeStart", end = "rangeEnd")
public class EventFilterParams {

  private String text;
  private List<@Positive Long> categories;
  private Boolean paid;
  private Boolean onlyAvailable = false;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime rangeStart;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime rangeEnd;

  private String sort = "VIEWS";
  private Integer from = 0;

  private Integer size = 10;

  public void setSize(Integer size) {
    this.size = size > 0 ? size : 10;
  }

  public Pageable toPageable() {
    if (sort.equals("VIEWS")) {
      return PageRequest.of(from / size, size, Sort.by("views").descending());
    } else if (sort.equals("DATE")) {
      return PageRequest.of(from / size, size, Sort.by("eventDate").descending());
    }
    return PageRequest.of(from / size, size);
  }
}
