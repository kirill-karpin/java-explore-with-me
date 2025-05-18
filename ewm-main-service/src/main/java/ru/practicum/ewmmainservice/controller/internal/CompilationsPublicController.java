package ru.practicum.ewmmainservice.controller.internal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CompilationsPublicController {

  @GetMapping("/compilations")
  public ResponseEntity<?> get() {
    return ResponseEntity.ok().build();
  }
}
