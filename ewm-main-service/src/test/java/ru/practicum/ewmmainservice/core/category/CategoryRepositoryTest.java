package ru.practicum.ewmmainservice.core.category;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CategoryRepositoryTest {

  @Autowired
  CategoryRepository categoryRepository;

  @Test
  public void setCategoryRepository() {
    Category category = new Category();
    category.setName("Java");
    Category newCategory = categoryRepository.save(category);
    assertNotNull(newCategory);

  }

}
