package ru.practicum.ewmmainservice.core.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

  private Double lat;
  private Double lon;
}
