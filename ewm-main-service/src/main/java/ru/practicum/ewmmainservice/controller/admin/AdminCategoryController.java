package ru.practicum.ewmmainservice.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

@Controller
@RequestMapping("/admin/categories")
class AdminCategoryController {

  @DeleteMapping("/{catId}")
  public ResponseEntity<?> delete(@PathVariable Long catId) {
    return null;
  }

  @PostMapping
  public ResponseEntity<?> post(@RequestBody CreateCategoryRequest request) {
    return null;
  }

  @PatchMapping("/{catId}")
  public ResponseEntity<?> patch(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
    return null;
  }
}
