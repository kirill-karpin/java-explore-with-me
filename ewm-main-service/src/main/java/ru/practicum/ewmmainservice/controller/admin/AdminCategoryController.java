package ru.practicum.ewmmainservice.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewmmainservice.core.category.CategoryService;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
@Tags({
    @Tag(name = "Admin: Категории", description = "API для работы с категориями"),
    @Tag(name = "admin"),
})
class AdminCategoryController {

  private final CategoryService categoryService;

  @DeleteMapping("/{catId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long catId) {
    categoryService.delete(catId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CategoryDto post(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
    return categoryService.create(createCategoryDto);
  }

  @PatchMapping("/{catId}")
  public CategoryDto updateCategory(@PathVariable Long catId,
      @Valid @RequestBody UpdateCategoryDto updateCategoryDto) {
    return categoryService.update(catId, updateCategoryDto);
  }
}
