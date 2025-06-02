package ru.practicum.ewmmainservice.core.event.service;

import dto.HitDto;
import dto.HitValue;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.client.StatClient;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.controller.admin.dto.AdminEventFilterRequest;
import ru.practicum.ewmmainservice.core.category.Category;
import ru.practicum.ewmmainservice.core.category.CategoryRepository;
import ru.practicum.ewmmainservice.core.event.Event;
import ru.practicum.ewmmainservice.core.event.EventMapper;
import ru.practicum.ewmmainservice.core.event.EventRepository;
import ru.practicum.ewmmainservice.core.event.EventState;
import ru.practicum.ewmmainservice.core.event.EventStateAction;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventDto;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;
import ru.practicum.ewmmainservice.core.exceptions.ConflictException;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;
import ru.practicum.ewmmainservice.core.like.EntityTypeEnum;
import ru.practicum.ewmmainservice.core.like.dto.CreateLikeDto;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;
import ru.practicum.ewmmainservice.core.like.service.LikeService;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestDto;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestMapper;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestRepository;
import ru.practicum.ewmmainservice.core.rating.RatingLikes;
import ru.practicum.ewmmainservice.core.rating.RatingLikesService;
import ru.practicum.ewmmainservice.core.user.User;
import ru.practicum.ewmmainservice.core.user.UserRepository;

@Service
@RequiredArgsConstructor
class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;
  private final UserRepository userRepository;
  private final CategoryRepository categoryRepository;
  private final ParticipationRequestRepository participationRequestRepository;
  private final EventMapper mapper;
  private final ParticipationRequestMapper participationRequestMapper;
  private final StatClient statClient;
  private final LikeService likeService;
  private final RatingLikesService ratingLikesService;

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

    if (updateEventDto.getStateAction() != null) {
      if (event.getState().equals(EventState.PUBLISHED.name())
          && updateEventDto.getStateAction() == EventStateAction.PUBLISH_EVENT) {
        throw new ConflictException("Событие уже опубликовано", "");
      }

      if (event.getState().equals(EventState.REJECTED.name())
          && updateEventDto.getStateAction() == EventStateAction.PUBLISH_EVENT) {
        throw new ConflictException("Нельзя опубликовать отклоненное событие", "");
      }

      if (event.getState().equals(EventState.PUBLISHED.name())
          && updateEventDto.getStateAction() == EventStateAction.REJECT_EVENT) {
        throw new ConflictException("Нельзя отклонить опубликованное событие", "");
      }
    }

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
    Event event = eventRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (!event.isPublished()) {
      throw new NotFoundException("Событие не опубликовано");
    }

    return mapper.toDto(event);
  }

  @Override
  public List<EventDto> getList(EventFilterParams filter) {

    Specification<Event> spec = Specification.where(
            EventSpecifications.hasAnnotation(filter.getText()))
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
    event.setState(EventState.PENDING.name());
    event.setCreatedOn(Instant.now());
    event.setViews(0L);

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
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("user not found"));

    Event event = eventRepository.findByIdAndInitiatorid(eventId, user)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (event.getState().equals(EventState.PUBLISHED.name())) {
      throw new ConflictException("Нельзя изменить опубликованное событие", "");
    }

    Event updateEvent = mapper.partialUpdate(request, event);

    return mapper.toDto(eventRepository.save(updateEvent));
  }

  @Override
  public List<EventDto> getUserEvents(Long userId, Paging paging) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    return eventRepository.findAllByInitiatorid(user, paging.toPageable()).stream()
        .map(mapper::toDto).toList();
  }

  @Override
  public List<EventDto> getList(AdminEventFilterRequest filter) {
    Specification<Event> spec = Specification.where(
            EventSpecifications.withUsers(filter.getUsers()))
        .and(EventSpecifications.withStates(filter.getStates()))
        .and(EventSpecifications.withCategories(filter.getCategories()))
        .and(EventSpecifications.dateBetween(filter.getRangeStart(), filter.getRangeEnd()));

    Pageable pageable = filter.toPageable();

    return eventRepository.findAll(spec, pageable).stream().map(mapper::toDto).toList();

  }

  @Override
  public List<ParticipationRequestDto> getUserEventRequests(Long userId, Long eventId) {

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    Event event = eventRepository.findById(eventId)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (!event.getInitiatorid().getId().equals(user.getId())) {
      throw new NotFoundException("Это не ваше событие");
    }

    return participationRequestRepository.getAllByEventid_Id(eventId).stream()
        .map(participationRequestMapper::toDto).toList();

  }

  @Override
  @Transactional
  public void incrementViews(Long eventId, HitDto hitDto) {
    statClient.hit(hitDto);
    LocalDateTime start = LocalDateTime.now().minusYears(1);
    LocalDateTime end = LocalDateTime.now().plusYears(1);
    List<HitValue> stats = statClient.getStatsList(start,
        end,
        List.of(hitDto.getUri()), true);
    stats.stream().filter(stat -> stat.getUri().equals(hitDto.getUri())).findFirst()
        .ifPresent(stat -> eventRepository.incrementViews(eventId, stat.getHits()));
  }

  @Override
  public void incrementViews(HitDto hitDto) {
    statClient.hit(hitDto);
  }

  @Override
  public LikeDto likeEvent(Long userId, Long eventId) {
    userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    Event event = eventRepository.findById(eventId)
        .orElseThrow(() -> new NotFoundException("Event not found"));

    if (!event.isPublished()) {
      throw new NotFoundException("Событие не опубликовано");
    }

    CreateLikeDto createLikeDto = CreateLikeDto.builder()
        .entityId(eventId)
        .entityType(EntityTypeEnum.EVENT)
        .userId(userId)
        .value(1L)
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build();
    try {
      return likeService.likeEntity(createLikeDto);
    } catch (RuntimeException e) {
      throw new ConflictException("Ошибка повторный лайк", e.getMessage());
    }
  }

  @Override
  public void deleteLike(Long userId, Long likeId) {
    try {
      likeService.deleteLike(userId, likeId);
    } catch (RuntimeException e) {
      throw new ConflictException("Ошибка удаления лайка", "");
    }
  }

  @Override
  public List<EventDto> getMostPopular() {
    List<RatingLikes> ratingLikes = ratingLikesService.getTop10EventsByLikesAllTime();
    List<Long> eventIds = ratingLikes.stream().map(RatingLikes::getEntityId).toList();
    if (eventIds.isEmpty()) {
      return List.of();
    }
    return eventRepository.findAllByIdInOrderByRatingDesc(eventIds).stream()
        .map(mapper::toDto).toList();
  }
}
