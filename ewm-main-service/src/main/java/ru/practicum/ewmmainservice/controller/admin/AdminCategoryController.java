package ru.practicum.ewmmainservice.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.category.CategoryDto;
import ru.practicum.ewmmainservice.core.category.CategoryService;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
@Tags({
    @Tag(name = "Admin: Категории", description = "API для работы с категориями")
})
class AdminCategoryController {

  private final CategoryService categoryService;

  @DeleteMapping("/{catId}")
  public void delete(@PathVariable Long catId) {
    categoryService.delete(catId);
  }

  @PostMapping
  public CategoryDto post(@RequestBody CreateCategoryRequest createCategoryRequest) {
    return categoryService.create(createCategoryRequest);
  }

  @PatchMapping("/{catId}")
  public CategoryDto patch(@PathVariable Long catId,
      @RequestBody UpdateCategoryRequest updateCategoryRequest) {
    return categoryService.update(catId, updateCategoryRequest);
  }
}
