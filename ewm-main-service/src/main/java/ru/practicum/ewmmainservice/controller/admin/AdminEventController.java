package ru.practicum.ewmmainservice.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/events")
class AdminEventController {

  @GetMapping
  public ResponseEntity<?> get() {
    return null;
  }
}
