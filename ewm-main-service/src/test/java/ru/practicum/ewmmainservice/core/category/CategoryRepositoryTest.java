package ru.practicum.ewmmainservice.core.category;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CategoryRepositoryTest {

  private final CategoryRepository categoryRepository;

  @Test
  public void setCategoryRepository() {
    Category category = new Category();
    category.setName("Java");
    Category newCategory = categoryRepository.save(category);
    assertNotNull(newCategory);

  }

}
