package ru.practicum.ewmmainservice.core.event;

import java.util.List;
import ru.practicum.ewmmainservice.common.CRUDService;
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

  @Override
  EventDto getById(Long id);
}
