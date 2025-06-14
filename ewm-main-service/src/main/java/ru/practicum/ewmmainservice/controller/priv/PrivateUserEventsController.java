package ru.practicum.ewmmainservice.controller.priv;

import static org.springframework.http.HttpStatus.CREATED;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.controller.priv.dto.ParticipationConfirmDto;
import ru.practicum.ewmmainservice.core.event.dto.CreateEventDto;
import ru.practicum.ewmmainservice.core.event.dto.EventDto;
import ru.practicum.ewmmainservice.core.event.dto.UpdateEventDto;
import ru.practicum.ewmmainservice.core.event.service.EventService;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestDto;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestService;
import ru.practicum.ewmmainservice.core.participation.ParticipationsList;
import ru.practicum.ewmmainservice.core.user.UserService;

@RestController
@RequestMapping("/users")
@Tags({
    @Tag(name = "Private: События\n", description = "Закрытый API для работы с событиями пользователя")})
@RequiredArgsConstructor
class PrivateUserEventsController {

  private final EventService eventService;
  private final ParticipationRequestService participationRequestService;
  private final UserService userService;

  @GetMapping("/{userId}/events")
  public List<EventDto> getUserEvents(@PathVariable Long userId, Paging paging) {
    return eventService.getUserEvents(userId, paging);
  }

  @PostMapping("/{userId}/events")
  @ResponseStatus(CREATED)
  public EventDto createEvent(@PathVariable Long userId,
      @Valid @RequestBody CreateEventDto request) {
    return eventService.createUserEvent(userId, request);
  }

  @GetMapping("/{userId}/events/{eventId}")
  public EventDto getEvent(@PathVariable Long userId, @PathVariable Long eventId) {
    return eventService.getUserEventById(userId, eventId);
  }

  @PatchMapping("/{userId}/events/{eventId}")
  public EventDto updateEventById(@PathVariable Long userId, @PathVariable Long eventId,
      @Valid @RequestBody UpdateEventDto request) {
    return eventService.updateUserEventById(userId, eventId, request);
  }

  @GetMapping("/{userId}/events/{eventId}/requests")
  public List<ParticipationRequestDto> getEventRequests(@PathVariable Long userId,
      @PathVariable Long eventId) {
    return eventService.getUserEventRequests(userId, eventId);
  }

  @PatchMapping("/{userId}/events/{eventId}/requests")
  public ParticipationsList updateEventRequests(@PathVariable Long userId,
      @PathVariable Long eventId, @RequestBody ParticipationConfirmDto request) {
    return participationRequestService.confirmUserEventRequests(userId, eventId, request);
  }

  @GetMapping("/{userId}/likes")
  public List<LikeDto> getUserLikes(@PathVariable Long userId, Paging paging) {
    return userService.getUserLikes(userId, paging);
  }

  @PostMapping("/{userId}/like/event/{eventId}")
  @ResponseStatus(HttpStatus.CREATED)
  public LikeDto likeEvent(@PathVariable Long userId, @PathVariable Long eventId) {
    return eventService.likeEvent(userId, eventId);
  }

  @DeleteMapping("/{userId}/like/{likeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLikeEvent(@PathVariable Long userId, @PathVariable Long likeId) {
    eventService.deleteLike(userId, likeId);
  }

}
