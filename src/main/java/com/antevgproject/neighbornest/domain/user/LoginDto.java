package com.antevgproject.neighbornest.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements Serializable {

    private Integer userId;
    private String roleName;
    private String firstName;
    private String lastName;

}
