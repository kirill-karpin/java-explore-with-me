package ru.practicum.ewmmainservice.controller.priv;

import static org.springframework.http.HttpStatus.CREATED;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestDto;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequestService;

@RestController
@RequestMapping("/users/{userId}/requests")
@Tags({
    @Tag(
        name = "Private: Запросы на участие",
        description = "Закрытый API для работы с запросами текущего пользователя на участие в событиях")})
@RequiredArgsConstructor
class PrivateUsersRequestController {


  private final ParticipationRequestService participationRequestService;

  @GetMapping
  public List<ParticipationRequestDto> getRequests(@PathVariable Long userId) {
    return participationRequestService.getAllByUserId(userId);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public ParticipationRequestDto createRequest(@PathVariable Long userId,
      @RequestParam Long eventId) {
    return participationRequestService.create(userId, eventId);
  }

  @PatchMapping("{requestId}/cancel")
  public ParticipationRequestDto cancelRequest(@PathVariable Long userId,
      @PathVariable Long requestId) {
    return participationRequestService.cancel(userId, requestId);
  }


}
