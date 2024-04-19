package com.planbtech.prostudy.DTO;

import com.planbtech.prostudy.entities.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long userId;
    private String userName;
    private String userPassword;
    private String userEmail;

    public UserDTO(User entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.userPassword = entity.getUserPassword();
        this.userEmail = entity.getUserEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;

        if (!getUserId().equals(userDTO.getUserId())) return false;
        if (!getUserName().equals(userDTO.getUserName())) return false;
        if (!getUserPassword().equals(userDTO.getUserPassword())) return false;
        return getUserEmail().equals(userDTO.getUserEmail());
    }

    @Override
    public int hashCode() {
        int result = getUserId().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getUserPassword().hashCode();
        result = 31 * result + getUserEmail().hashCode();
        return result;
    }

}
