package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.domain.resident.Resident;
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
public class ValidUserDto implements Serializable {

    private String userUsername;

    @NotNull
    @Size(max = 255)
    private String email;
    @NotNull
    @Size(max = 255)
    private String phone;

}