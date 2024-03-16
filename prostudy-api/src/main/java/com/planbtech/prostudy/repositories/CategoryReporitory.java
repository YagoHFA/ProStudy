package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CategoryReporitory extends JpaRepository<Category, Long> {
}
