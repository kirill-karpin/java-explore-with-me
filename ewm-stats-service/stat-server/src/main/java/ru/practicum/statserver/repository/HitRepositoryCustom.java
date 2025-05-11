package ru.practicum.statserver.repository;


import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;

public interface HitRepositoryCustom {

  List<HitValue> filterByParams(LocalDateTime start, LocalDateTime end, List<String> uris,
      Boolean unique);

}
