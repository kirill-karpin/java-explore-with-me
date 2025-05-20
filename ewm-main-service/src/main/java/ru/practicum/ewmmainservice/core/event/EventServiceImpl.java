package ru.practicum.ewmmainservice.core.event;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventRequest;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventRequest;

@Service
@RequiredArgsConstructor
class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;
  private final EventMapper mapper;

  @Override
  public EventDto create(CreateEventRequest createEventRequest) {
    Event event = mapper.toEntity(createEventRequest);
    Event savedEvent = eventRepository.save(event);
    return mapper.toDto(savedEvent);
  }

  @Override
  public EventDto update(Long id, UpdateEventRequest updateEventRequest) {
    eventRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found"));

    Event updatedEvent = mapper.toEntity(updateEventRequest);
    updatedEvent.setId(id);
    return mapper.toDto(eventRepository.save(updatedEvent));
  }

  @Override
  public void delete(Long id) {
    Event event = eventRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found"));

    eventRepository.delete(event);
  }

  @Override
  public List<EventDto> getList() {
    return eventRepository.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public EventDto getById(Long id) {
    return mapper.toDto(eventRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found")));
  }
}
