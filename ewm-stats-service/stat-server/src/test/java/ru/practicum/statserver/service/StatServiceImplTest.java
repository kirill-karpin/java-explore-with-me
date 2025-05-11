package ru.practicum.statserver.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import dto.CreateHitDto;
import dto.HitDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import({StatServiceImpl.class})
class StatServiceImplTest {

  @Autowired
  private StatService statService;

  @Test
  void createEvent() {

    CreateHitDto eventDto = CreateHitDto.builder().
        app("test")
        .ip("1.1.1.1")
        .uri("/test")
        .timestamp(LocalDateTime.parse("2025-01-01T01:01:01"))
    .build();

    HitDto event = statService.createEvent(eventDto);
    assertNotNull(event);
    assertNotNull(event.getApp());

  }

  @Test
  void getEvent() {
  }
}
