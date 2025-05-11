package ru.practicum.statserver.controller;

import dto.CreateHitDto;
import dto.HitDto;

import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.statserver.service.StatService;

@RestController
class StatController {

  private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

  private StatService statService;

  StatController(StatService statService) {
    this.statService = statService;
  }

  @PostMapping("/hit")
  public HitDto createEvent(@RequestBody CreateHitDto createHitDto) {
    return statService.createEvent(createHitDto);
  }

  @GetMapping("/stats")
  public List<HitValue> getStats(
      @RequestParam(required = true) @DateTimeFormat(pattern = DATE_TIME_FORMAT) LocalDateTime start,
      @RequestParam @DateTimeFormat(pattern = DATE_TIME_FORMAT) LocalDateTime end,
      @RequestParam(required = false) List<String> uris,
      @RequestParam(defaultValue = "false") Boolean unique) {

    return statService.getStats(start, end, uris, unique);
  }

}
