package ru.practicum.ewmmainservice.controller.internal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CategoriesPublicController {

  @GetMapping("/categories")
  public ResponseEntity<?> getList() {
    return ResponseEntity.ok().build();
  }

  @GetMapping("/categories/{catId}")
  public ResponseEntity<?> get() {
    return ResponseEntity.ok().build();
  }
}
