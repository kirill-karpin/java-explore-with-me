package ru.practicum.ewmmainservice.core.category;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper mapper;

  @Override
  public CategoryDto create(CreateCategoryRequest createCategoryRequest) {

    Category category = mapper.toEntity(createCategoryRequest);
    Category createdCategory = categoryRepository.save(category);

    return mapper.toDto(createdCategory);
  }

  @Override
  public CategoryDto update(Long categoryId, UpdateCategoryRequest updateCategoryRequest) {

    categoryRepository.findById(categoryId)
        .orElseThrow(() -> new RuntimeException("Category not found"));

    Category categoryToUpdate = mapper.toEntity(updateCategoryRequest);
    categoryToUpdate.setId(categoryId);

    Category updatedCategory = categoryRepository.save(categoryToUpdate);

    return mapper.toDto(updatedCategory);
  }

  @Override
  public void delete(Long categoryId) {

    categoryRepository.findById(categoryId)
        .orElseThrow(() -> new RuntimeException("Category not found"));

    categoryRepository.deleteById(categoryId);
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
        () -> new RuntimeException("Category not found")
    );
  }
}
