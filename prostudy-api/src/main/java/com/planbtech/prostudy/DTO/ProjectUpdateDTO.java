package com.planbtech.prostudy.DTO;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUpdateDTO {
    private String id;
    private String title;
    private String description;
    private List<String> tools;
}
