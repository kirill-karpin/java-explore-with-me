package ru.practicum.ewmmainservice.core.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mapping(target = "id", ignore = true)
  Category toEntity(CreateCategoryDto destination);

  CategoryDto toDto(Category destination);

  Category toEntity(UpdateCategoryDto destination);

}
