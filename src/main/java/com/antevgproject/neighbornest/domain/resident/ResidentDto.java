package com.antevgproject.neighbornest.domain.resident;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Resident}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDto implements Serializable {

    private String userUsername;
    private String userPassword;
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
    @NotNull
    @Size(max = 255)
    private String email;
    @NotNull
    @Size(max = 255)
    private String phone;
    @NotNull
    private LocalDate birthdate;

}