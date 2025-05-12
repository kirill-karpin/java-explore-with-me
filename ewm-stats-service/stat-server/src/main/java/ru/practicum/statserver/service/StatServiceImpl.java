package ru.practicum.statserver.service;

import dto.CreateHitDto;
import dto.HitDto;
import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.statserver.mapper.StatMapper;
import ru.practicum.statserver.model.Hit;
import ru.practicum.statserver.repository.HitRepository;

@Slf4j
@Service
class StatServiceImpl implements StatService {

  private final HitRepository hitRepository;

  StatServiceImpl(HitRepository hitRepository) {
    this.hitRepository = hitRepository;
  }

  @Override
  public HitDto createEvent(CreateHitDto createHitDto) {

    Hit event = hitRepository.save(StatMapper.toEntity(createHitDto));

    return StatMapper.toDto(event);
  }

  @Override
  public List<HitValue> getStats(LocalDateTime start, LocalDateTime end, List<String> uris,
      Boolean unique) {
    return hitRepository.filterByParams(start, end, uris, unique);
  }
}
