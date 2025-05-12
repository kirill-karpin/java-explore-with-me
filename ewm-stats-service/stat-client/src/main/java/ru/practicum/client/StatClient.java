package ru.practicum.client;

import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;

public interface StatClient {

  List<HitValue> getStatsList(LocalDateTime start, LocalDateTime end, List<String> uris,
      Boolean unique);
}
