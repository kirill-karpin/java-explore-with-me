package ru.practicum.ewmmainservice.controller.priv;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tags({
    @Tag(name = "Private: События\n", description = "Закрытый API для работы с событиями пользователя")})
class PrivateUsersController {

  @GetMapping("/{userId}/events")
  public ResponseEntity<?> getUserEvents(@PathVariable long userId) {
    return ResponseEntity.ok("get user events");
  }

  @PostMapping("/{userId}/events")
  public ResponseEntity<?> createEvent(@PathVariable long userId) {
    return ResponseEntity.ok("get user events");
  }

  @PostMapping("/{userId}/events/{eventId}")
  public ResponseEntity<?> getEvent(@PathVariable long userId, @PathVariable long eventId) {
    return ResponseEntity.ok("get user events");
  }

  @PatchMapping("/{userId}/events/{eventId}")
  public ResponseEntity<?> updateEventById(@PathVariable long userId, @PathVariable long eventId) {
    return ResponseEntity.ok("get user events");
  }

  @GetMapping("/{userId}/events/{eventId}/requests")
  public ResponseEntity<?> getEventRequests(@PathVariable long userId, @PathVariable long eventId) {
    return ResponseEntity.ok("get user events");
  }

  @PatchMapping("/{userId}/events/{eventId}/requests")
  public ResponseEntity<?> updateEventRequests(@PathVariable long userId,
      @PathVariable long eventId) {
    return ResponseEntity.ok("get user events");
  }


}
