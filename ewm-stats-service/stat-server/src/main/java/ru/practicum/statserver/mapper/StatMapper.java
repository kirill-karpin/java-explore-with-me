package ru.practicum.statserver.mapper;

import dto.CreateHitDto;
import dto.HitDto;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import ru.practicum.statserver.model.Hit;

public class StatMapper {

  public static Hit toEntity(CreateHitDto dto) {
    Hit hit = new Hit();
    hit.setApp(dto.getApp());
    hit.setUri(dto.getUri());
    hit.setIp(dto.getIp());
    hit.setCreated(dto.getTimestamp().toInstant(ZoneOffset.UTC));
    return hit;
  }

  public static HitDto toDto(Hit entity) {
    return HitDto.builder()
        .app(entity.getApp())
        .ip(entity.getIp())
        .uri(entity.getUri())
        .timestamp(LocalDateTime.ofInstant(entity.getCreated(), ZoneOffset.UTC))
        .build();
  }
}
