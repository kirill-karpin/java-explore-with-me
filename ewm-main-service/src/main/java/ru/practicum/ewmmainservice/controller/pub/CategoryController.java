package ru.practicum.ewmmainservice.controller.pub;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.category.CategoryService;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@Tags(@Tag(name = "Public: Категории", description = "Публичный API для работы с категориями"))
class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public List<CategoryDto> get() {
    return categoryService.getList();
  }

  @GetMapping("/{categoryId}")
  public CategoryDto getCategory(@PathVariable Long categoryId) {
    return categoryService.getById(categoryId);
  }

}
