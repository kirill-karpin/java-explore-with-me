package ru.practicum.statserver.service;

import dto.CreateHitDto;
import dto.HitDto;
import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;

public interface StatService {

  HitDto createEvent(CreateHitDto createHitDto);

  List<HitValue> getStats(LocalDateTime start, LocalDateTime end, List<String> uris,
      Boolean unique);
}
