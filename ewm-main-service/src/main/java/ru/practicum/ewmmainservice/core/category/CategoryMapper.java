package ru.practicum.ewmmainservice.core.category;

import org.mapstruct.Mapper;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  Category toEntity(CreateCategoryRequest destination);

  CategoryDto toDto(Category destination);

  Category toEntity(UpdateCategoryRequest destination);

}
