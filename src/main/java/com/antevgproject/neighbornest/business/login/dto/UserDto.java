package com.antevgproject.neighbornest.business.login.dto;

import com.antevgproject.neighbornest.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private String roleName;
    private String username;
    private String password;
}