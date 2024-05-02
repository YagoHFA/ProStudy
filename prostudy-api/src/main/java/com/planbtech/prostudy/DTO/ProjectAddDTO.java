package com.planbtech.prostudy.DTO;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAddDTO {

    private String projectOwner;
    private String projectName;
    private List<String> tools;
    private String Shortdescription;
    private String projectURL;

}
