package com.planbtech.prostudy;

import com.planbtech.prostudy.DTO.CategoryDTO;
import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CategoryTest {

    @Autowired
    private CategoryReporitory categoryReporitory;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findCatgoty(){
        Category category = new Category();
        category.setCategoryName("Front-End");
        category.setCategoryId(1L);
        categoryReporitory.save(category);

        Category categoryTest = categoryReporitory.findCategory("Front-End");

        assertEquals(new CategoryDTO(categoryTest), new CategoryDTO(category));
    }

    @Test
    void findAllCategories(){
        Category category = new Category();
        category.setCategoryName("Front-End");
        category.setCategoryId(1L);
        categoryReporitory.save(category);

        Category category2 = new Category();
        category2.setCategoryName("Back-End");
        category2.setCategoryId(2L);
        categoryReporitory.save(category2);

        Category category3 = new Category();
        category3.setCategoryName("");
        category3.setCategoryId(3L);
        categoryReporitory.save(category3);


        List<Category> categoryTest = new ArrayList<Category>();

        categoryTest.add(category);
        categoryTest.add(category2);
        categoryTest.add(category3);

        categoryReporitory.findAll().forEach(X -> System.out.println(X.getVideoList()));
        assertThat(categoryTest.stream().map(CategoryDTO::new).toList()).isEqualTo(categoryReporitory.findAll().stream().map(CategoryDTO::new).toList());
    }
}
