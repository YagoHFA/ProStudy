package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryReporitory extends JpaRepository<Category, Long> {

    @Query(value = "Select * from category where categoryname = ?1", nativeQuery = true)
    Category findCategory(String s);

    @Query(value = "Select cc from Category cc left join fetch cc.skillTestList")
    List<Category> findAllCategoryWithTest();

    Optional<Category> findByCategoryName(String categoryName);

    @Query(value = "select categoryname from category", nativeQuery = true)
    List<Category> findAllCategorName();
}
