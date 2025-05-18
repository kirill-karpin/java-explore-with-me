package ru.practicum.ewmmainservice.core.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.practicum.ewmmainservice.core.category.dto.CreateCategoryRequest;
import ru.practicum.ewmmainservice.core.category.dto.UpdateCategoryRequest;

@DataJpaTest
@Import({CategoryServiceImpl.class, CategoryMapperImpl.class})
class CategoryServiceImplTest {

  @Autowired
  CategoryService categoryService;


  @Test
  void create() {
    CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.builder().name("cat")
        .build();

    CategoryDto categoryDto = categoryService.create(createCategoryRequest);
    assertNotNull(categoryDto);
  }

  @Test
  void update() {
    CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.builder().name("cat")
        .build();

    CategoryDto categoryDto = categoryService.create(createCategoryRequest);
    assertNotNull(categoryDto);
    UpdateCategoryRequest updateCategoryRequest = UpdateCategoryRequest.builder()
        .name("newCat")
        .build();

    CategoryDto newCategoryDto = categoryService.update(categoryDto.getId(), updateCategoryRequest);

    assertEquals(newCategoryDto.getName(), "newCat");

  }

  @Test
  void delete() {

    CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.builder().name("cat")
        .build();

    CategoryDto categoryDto = categoryService.create(createCategoryRequest);
    assertNotNull(categoryDto);

    categoryService.delete(categoryDto.getId());

    assertEquals(0, categoryService.getAll().size());
  }
}
