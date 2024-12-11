package com.planbtech.prostudy.component.security.DTO;

import lombok.Builder;

@Builder
public record UserLoginDTO(String userName, String password) {

}
