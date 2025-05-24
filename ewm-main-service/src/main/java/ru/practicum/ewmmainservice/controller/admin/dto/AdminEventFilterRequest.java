package ru.practicum.ewmmainservice.controller.admin.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminEventFilterRequest {

  private List<Long> users;
  private List<String> states;
  private List<Long> categories;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime rangeStart;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime rangeEnd;

  private Integer from = 0;
  private Integer size = 10;

  public void setSize(Integer size) {
    this.size = size > 0 ? size : 10;
  }

  public Pageable toPageable() {
    return PageRequest.of(from / size, size);
  }

}
