package ru.practicum.ewmmainservice.core.event.service;

import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.category.Category;
import ru.practicum.ewmmainservice.core.category.CategoryRepository;
import ru.practicum.ewmmainservice.core.event.Event;
import ru.practicum.ewmmainservice.core.event.EventMapper;
import ru.practicum.ewmmainservice.core.event.EventRepository;
import ru.practicum.ewmmainservice.core.event.EventState;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventDto;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;
import ru.practicum.ewmmainservice.core.user.User;
import ru.practicum.ewmmainservice.core.user.UserRepository;

@Service
@RequiredArgsConstructor
class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;
  private final UserRepository userRepository;
  private final CategoryRepository categoryRepository;
  private final EventMapper mapper;

  @Override
  public EventDto create(CreateEventDto createEventDto) {
    Event event = mapper.toEntity(createEventDto);
    Event savedEvent = eventRepository.save(event);
    return mapper.toDto(savedEvent);
  }

  @Override
  public EventDto update(Long id, UpdateEventDto updateEventDto) {
    Event event = eventRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    Event updatedEvent = mapper.partialUpdate(updateEventDto, event);

    return mapper.toDto(eventRepository.save(updatedEvent));
  }

  @Override
  public void delete(Long id) {
    Event event = eventRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    eventRepository.delete(event);
  }

  @Override
  public List<EventDto> getList() {
    return eventRepository.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public EventDto getById(Long id) {
    return mapper.toDto(
        eventRepository.findById(id).orElseThrow(() -> new NotFoundException("Event not found")));
  }

  @Override
  public List<EventDto> getList(EventFilterParams filter) {

    Specification<Event> spec = Specification.where(EventSpecifications.hasTitle(filter.getText()))
        .and(EventSpecifications.isPaid(filter.getPaid()))
        .and(EventSpecifications.inCategories(filter.getCategories()))
        .and(EventSpecifications.dateBetween(filter.getRangeStart(), filter.getRangeEnd()))
        .and(EventSpecifications.isAvailable(filter.getOnlyAvailable()));

    Pageable pageable = filter.toPageable();

    return eventRepository.findAll(spec, pageable).stream().map(mapper::toDto).toList();
  }

  @Override
  public EventDto createUserEvent(Long userId, CreateEventDto request) {

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    Category category = categoryRepository.findById(request.getCategory())
        .orElseThrow(() -> new NotFoundException("Category not found"));

    Event event = mapper.toEntity(request);

    event.setInitiatorid(user);
    event.setCategoryid(category);
    event.setState(EventState.PENDING);
    event.setCreatedOn(Instant.now());

    return mapper.toDto(eventRepository.save(event));
  }

  @Override
  public EventDto getUserEventById(Long userId, Long eventId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("user not found"));

    Event event = eventRepository.findByIdAndInitiatorid(eventId, user)
        .orElseThrow(() -> new NotFoundException("event not found"));

    return mapper.toDto(event);
  }

  @Override
  public EventDto updateUserEventById(Long userId, Long eventId, UpdateEventDto request) {

    getUserEventById(userId, eventId);

    Event updateEvent = mapper.toEntity(request);

    return mapper.toDto(eventRepository.save(updateEvent));
  }

  @Override
  public List<EventDto> getUserEvents(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    return eventRepository.findAllByInitiatorid(user).stream().map(mapper::toDto).toList();
  }
}
