package ru.practicum.ewmmainservice.core.category;

import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

public interface CategoryService {

  CategoryDto create(CreateCategoryRequest createCategoryRequest);

  CategoryDto update(Long categoryId, UpdateCategoryRequest updateCategoryRequest);

  void delete(Long categoryId);
}
