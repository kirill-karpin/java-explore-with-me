package ru.practicum.ewmmainservice.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tags({
    @Tag(name = "Admin: Пользователи", description = "Контроллер работы с пользователями")
})
@RequestMapping("/admin/users")
class AdminUserController {

  @GetMapping
  public ResponseEntity<?> get() {
    return ResponseEntity.ok()
        .body("AdminUserController");
  }

  @PostMapping
  public ResponseEntity<?> post(@RequestBody Object value) {
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{userId}")
  public ResponseEntity<?> patch(@RequestBody Object value) {
    return ResponseEntity.ok().build();
  }
}
