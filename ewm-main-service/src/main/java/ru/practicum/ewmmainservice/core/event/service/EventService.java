package ru.practicum.ewmmainservice.core.event.service;

import java.util.List;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.controller.admin.dto.AdminEventFilterRequest;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventDto;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;

public interface EventService {

  EventDto create(CreateEventDto createEventDto);

  EventDto update(Long id, UpdateEventDto updateEventDto);

  void delete(Long id);

  List<EventDto> getList();

  List<EventDto> getList(EventFilterParams filter);

  EventDto getById(Long id);

  EventDto createUserEvent(Long userId, CreateEventDto request);

  EventDto getUserEventById(Long userId, Long eventId);

  EventDto updateUserEventById(Long userId, Long eventId, UpdateEventDto request);

  List<EventDto> getUserEvents(Long userId, Paging paging);

  List<EventDto> getList(AdminEventFilterRequest filter);
}
