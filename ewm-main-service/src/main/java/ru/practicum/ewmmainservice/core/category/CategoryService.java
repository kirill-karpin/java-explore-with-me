package ru.practicum.ewmmainservice.core.category;

import java.util.List;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryDto;

public interface CategoryService {

  CategoryDto create(CreateCategoryDto createCategoryDto);

  CategoryDto update(Long categoryId, UpdateCategoryDto updateCategoryDto);

  void delete(Long categoryId);

  List<CategoryDto> getList(Paging paging);

  CategoryDto getById(Long categoryId);
}
