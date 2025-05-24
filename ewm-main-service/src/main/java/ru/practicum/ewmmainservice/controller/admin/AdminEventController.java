package ru.practicum.ewmmainservice.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.controller.admin.dto.AdminEventFilterRequest;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;
import ru.practicum.ewmmainservice.core.event.service.EventService;

@RestController
@RequestMapping("/admin/events")
@Tags({
    @Tag(name = "Admin: События", description = "API для работы с событиями"),
    @Tag(name = "admin"),
})
@RequiredArgsConstructor
class AdminEventController {

  private final EventService eventService;

  @GetMapping
  public List<EventDto> getList(AdminEventFilterRequest filter) {
    return eventService.getList(filter);
  }

  @PatchMapping("/{eventId}")
  public EventDto update(@PathVariable Long eventId, @RequestBody UpdateEventDto updateEventDto) {
    return eventService.update(eventId, updateEventDto);
  }
}
