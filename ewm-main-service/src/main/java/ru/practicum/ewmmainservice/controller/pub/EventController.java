package ru.practicum.ewmmainservice.controller.pub;

import dto.HitDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.service.EventFilterParams;
import ru.practicum.ewmmainservice.core.event.service.EventService;

@RestController
@RequestMapping("/events")
@Tags({
    @Tag(
        name = "Public: События",
        description = "Публичный API для работы с событиями"
    )
})
@RequiredArgsConstructor
class EventController {

  public static final String EWM_MAIN_SERVICE = "ewm-main-service";
  private final EventService eventService;

  @GetMapping
  public List<EventDto> getList(@Valid EventFilterParams filter, HttpServletRequest request) {
    eventService.incrementViews(
        new HitDto(
            EWM_MAIN_SERVICE,
            request.getRequestURI(),
            request.getRemoteAddr(),
            LocalDateTime.now()
        )
    );
    return eventService.getList(filter);

  }

  @GetMapping("/{id}")
  public EventDto getById(@PathVariable Long id, HttpServletRequest request) {
    eventService.incrementViews(
        id,
        new HitDto(
            EWM_MAIN_SERVICE,
            request.getRequestURI(),
            request.getRemoteAddr(),
            LocalDateTime.now()
        )
    );
    return eventService.getById(id);
  }

  @GetMapping("/most-popular")
  public List<EventDto> getMostPopular() {
    return eventService.getMostPopular();
  }
}
