package ru.practicum.ewmmainservice.controller.admin.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserFilter {

  private List<Long> ids;

  private Integer from = 0;
  private Integer size = 10;

  public void setSize(Integer size) {
    this.size = size > 0 ? size : 10;
  }

  public Pageable toPageable() {
    return PageRequest.of(from / size, size);
  }

}
