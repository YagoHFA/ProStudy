package com.planbtech.prostudy.config.security.DTO;

import lombok.Builder;

@Builder
public record UserLoginDTO(String userName, String password) {

}
