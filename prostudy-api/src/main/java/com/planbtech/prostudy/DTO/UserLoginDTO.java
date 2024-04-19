package com.planbtech.prostudy.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
