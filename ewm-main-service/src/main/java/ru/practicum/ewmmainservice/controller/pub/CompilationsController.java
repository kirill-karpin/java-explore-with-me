package ru.practicum.ewmmainservice.controller.pub;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compilations")
@Tags({
    @Tag(name = "Public: Подборки событий", description = "Публичный API для работы с подборками событий")})
class CompilationsController {

  @GetMapping
  public ResponseEntity<?> getList() {
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{compId}")
  public ResponseEntity<?> getById(@PathVariable Long compId) {
    return ResponseEntity.ok().build();
  }
}
