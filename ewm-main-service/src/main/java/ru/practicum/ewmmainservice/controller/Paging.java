package ru.practicum.ewmmainservice.controller;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
public class Paging {

  private Integer from = 0;
  private Integer size = 10;

  public void setSize(Integer size) {
    this.size = size > 0 ? size : 10;
  }

  public Pageable toPageable() {
    return PageRequest.of(from / size, size);
  }
}
