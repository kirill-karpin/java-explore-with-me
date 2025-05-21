package ru.practicum.ewmmainservice.core.event.service;

import java.util.List;
import ru.practicum.ewmmainservice.core.CRUDService;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventRequest;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventRequest;

public interface EventService extends
    CRUDService<Long, CreateEventRequest, UpdateEventRequest, EventDto> {

  @Override
  EventDto create(CreateEventRequest createEventRequest);

  @Override
  EventDto update(Long id, UpdateEventRequest updateEventRequest);

  @Override
  void delete(Long id);

  @Override
  List<EventDto> getList();

  List<EventDto> getList(EventFilterParams filter);

  @Override
  EventDto getById(Long id);

  EventDto createUserEvent(Long userId, CreateEventRequest request);

  EventDto getUserEventById(Long userId, Long eventId);

  EventDto updateUserEventById(Long userId, Long eventId, UpdateEventRequest request);
}
