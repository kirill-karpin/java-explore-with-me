package ru.practicum.ewmmainservice.controller.pub;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
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

  private final EventService eventService;

  @GetMapping
  public List<EventDto> getList(EventFilterParams filter) {

    return eventService.getList(filter);

  }

  @GetMapping("/{id}")
  public EventDto getById(@PathVariable Long id) {
    return eventService.getById(id);
  }
}
