package ru.practicum.ewmmainservice.core.category;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryDto;
import ru.practicum.ewmmainservice.core.exceptions.ConflictException;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper mapper;

  @Override
  public CategoryDto create(CreateCategoryDto createCategoryDto) {

    Category category = mapper.toEntity(createCategoryDto);
    try {
      Category createdCategory = categoryRepository.save(category);

      return mapper.toDto(createdCategory);
    } catch (DataIntegrityViolationException e) {
      throw new ConflictException("Integrity constraint has been violated", e.getMessage());
    }

  }

  @Override
  public CategoryDto update(Long categoryId, UpdateCategoryDto updateCategoryDto) {

    categoryRepository.findById(categoryId)
        .orElseThrow(() -> new NotFoundException("Category not found"));

    Category categoryToUpdate = mapper.toEntity(updateCategoryDto);
    categoryToUpdate.setId(categoryId);

    try {
      Category updatedCategory = categoryRepository.save(categoryToUpdate);
      return mapper.toDto(updatedCategory);
    } catch (DataIntegrityViolationException e) {
      throw new ConflictException("Integrity constraint has been violated", e.getMessage());
    }
  }

  @Override
  public void delete(Long categoryId) {

    categoryRepository.findById(categoryId)
        .orElseThrow(() -> new NotFoundException("Category not found"));

    try {
      categoryRepository.deleteById(categoryId);
    } catch (DataIntegrityViolationException e) {
      throw new ConflictException("Integrity constraint has been violated", e.getMessage());
    }
  }

  @Override
  public List<CategoryDto> getList() {
    return categoryRepository.findAll()
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  @Override
  public CategoryDto getById(Long categoryId) {
    return categoryRepository.findById(categoryId).map(mapper::toDto).orElseThrow(
        () -> new NotFoundException("Category not found")
    );
  }
}
