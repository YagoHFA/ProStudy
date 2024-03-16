package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
    @Query(value = "Select * from video where category = ?1",nativeQuery = true)
    List<Video> findAllByCategory(String category);
}
