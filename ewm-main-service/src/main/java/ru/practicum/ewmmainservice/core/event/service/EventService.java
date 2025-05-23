package ru.practicum.ewmmainservice.core.event.service;

import java.util.List;
import ru.practicum.ewmmainservice.core.CRUDService;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventDto;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;

public interface EventService extends
    CRUDService<Long, CreateEventDto, UpdateEventDto, EventDto> {

  @Override
  EventDto create(CreateEventDto createEventDto);

  @Override
  EventDto update(Long id, UpdateEventDto updateEventDto);

  @Override
  void delete(Long id);

  @Override
  List<EventDto> getList();

  List<EventDto> getList(EventFilterParams filter);

  @Override
  EventDto getById(Long id);

  EventDto createUserEvent(Long userId, CreateEventDto request);

  EventDto getUserEventById(Long userId, Long eventId);

  EventDto updateUserEventById(Long userId, Long eventId, UpdateEventDto request);

  List<EventDto> getUserEvents(Long userId);
}
