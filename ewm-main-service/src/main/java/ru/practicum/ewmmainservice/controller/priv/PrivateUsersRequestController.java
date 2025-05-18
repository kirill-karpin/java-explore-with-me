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
@RequestMapping("/users/{userId}/requests")
@Tags({
    @Tag(
        name = "Private: Запросы на участие",
        description = "Закрытый API для работы с запросами текущего пользователя на участие в событиях")})
class PrivateUsersRequestController {

  @GetMapping
  public ResponseEntity<?> getRequests(@PathVariable long userId) {
    return ResponseEntity.ok("get user events");
  }

  @PostMapping
  public ResponseEntity<?> createRequest(@PathVariable long userId) {
    return ResponseEntity.ok("get user events");
  }

  @PatchMapping("{requestId}/cancel")
  public ResponseEntity<?> cancelRequest(@PathVariable long userId,
      @PathVariable long requestId) {
    return ResponseEntity.ok("get user events");
  }


}
