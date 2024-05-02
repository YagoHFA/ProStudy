package com.planbtech.prostudy.DTO.CategoryDTO;

import com.planbtech.prostudy.DTO.VideoDTO.VideoDTO;
import com.planbtech.prostudy.entities.model.Category;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVideoDTO {

    private Long  categoryId;
    private String categoryName;
    private List<VideoDTO> videoList;

    public CategoryVideoDTO(Category entity) {
        this.categoryId = entity.getCategoryId();
        this.categoryName = entity.getCategoryName();
        this.videoList = entity.getVideoList().stream().map(VideoDTO::new).toList();
    }
}
