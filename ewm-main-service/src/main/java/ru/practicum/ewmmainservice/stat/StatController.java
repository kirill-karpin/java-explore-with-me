package ru.practicum.ewmmainservice.stat;

import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.client.StatClient;

@RestController
class StatController {

  private final StatClient statClient;

  StatController(StatClient statClient) {
    this.statClient = statClient;
  }

  @GetMapping("/get-stat")
  public List<HitValue> get() {
    return statClient.getStatsList(
        LocalDateTime.now().minusDays(90),
        LocalDateTime.now().plusDays(60),
        List.of("ewm-main-service"),
        false
    );
  }

}
