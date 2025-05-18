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
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

@RestController
@RequestMapping("/admin/categories")
@Tags({
    @Tag(name = "Admin: Категории", description = "API для работы с категориями")
})
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
