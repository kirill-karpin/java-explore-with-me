package ru.practicum.ewmmainservice.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/compilations")
@Tags({
    @Tag(name = "Admin: Подборки событий", description = "API для работы с подборками событий")
})
class AdminCompilationsController {

  @PostMapping
  public ResponseEntity<?> post(@RequestBody boolean value) {
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{compId}")
  public ResponseEntity<?> delete(@PathVariable Long compId) {
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{compId}")
  public ResponseEntity<?> patch(@PathVariable Long compId) {
    return ResponseEntity.ok().build();
  }

}
