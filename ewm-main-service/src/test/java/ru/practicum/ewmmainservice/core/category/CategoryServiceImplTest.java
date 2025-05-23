package ru.practicum.ewmmainservice.core.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.practicum.ewmmainservice.core.category.dto.CategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryDto;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryDto;

@DataJpaTest
@Import({CategoryServiceImpl.class, CategoryMapperImpl.class})
class CategoryServiceImplTest {

  @Autowired
  CategoryService categoryService;


  @Test
  void create() {
    CreateCategoryDto createCategoryDto = CreateCategoryDto.builder().name("cat")
        .build();

    CategoryDto categoryDto = categoryService.create(createCategoryDto);
    assertNotNull(categoryDto);
  }

  @Test
  void update() {
    CreateCategoryDto createCategoryDto = CreateCategoryDto.builder().name("cat")
        .build();

    CategoryDto categoryDto = categoryService.create(createCategoryDto);
    assertNotNull(categoryDto);
    UpdateCategoryDto updateCategoryDto = UpdateCategoryDto.builder()
        .name("newCat")
        .build();

    CategoryDto newCategoryDto = categoryService.update(categoryDto.getId(), updateCategoryDto);

    assertEquals("newCat", newCategoryDto.getName());

  }

  @Test
  void delete() {

    CreateCategoryDto createCategoryDto = CreateCategoryDto.builder().name("cat")
        .build();

    CategoryDto categoryDto = categoryService.create(createCategoryDto);
    assertNotNull(categoryDto);

    categoryService.delete(categoryDto.getId());
  }
}
