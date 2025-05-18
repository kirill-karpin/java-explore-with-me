package ru.practicum.ewmmainservice.controller.pub;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@Tags(@Tag(name = "Public: Категории", description = "Публичный API для работы с категориями"))
class CategoryController {

  @GetMapping
  public ResponseEntity<?> get() {
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
    return ResponseEntity.ok().build();
  }

}
