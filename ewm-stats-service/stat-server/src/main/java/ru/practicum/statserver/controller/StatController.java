package ru.practicum.statserver.controller;

import dto.CreateHitDto;
import dto.HitDto;
import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.statserver.service.StatService;

@RestController
class StatController {

  private final StatService statService;

  StatController(StatService statService) {
    this.statService = statService;
  }

  @PostMapping("/hit")
  public HitDto createEvent(@RequestBody CreateHitDto createHitDto) {
    return statService.createEvent(createHitDto);
  }

  @GetMapping("/stats")
  public List<HitValue> getStats(
      @RequestParam LocalDateTime start,
      @RequestParam LocalDateTime end,
      @RequestParam(required = false) List<String> uris,
      @RequestParam(defaultValue = "false") Boolean unique) {

    return statService.getStats(start, end, uris, unique);
  }

}
