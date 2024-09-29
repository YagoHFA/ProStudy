package com.planbtech.prostudy.DTO.ProjectDTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectToSendDTO {
    private String sender;
    private String receiver;
    private String name;
    private String description;
    private String URLDoc;

}
