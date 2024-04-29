package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CategoryReporitory extends JpaRepository<Category, Long> {

    @Query(value = "Select * from category where categoryname = ?1", nativeQuery = true)
    Category findCategory(String s);

    @Query(value = "Select cc from Category cc left join fetch cc.skillTestList")
    List<Category> findAllCategoryWithTest();

}
