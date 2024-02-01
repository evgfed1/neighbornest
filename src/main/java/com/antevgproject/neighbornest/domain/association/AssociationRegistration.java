package com.antevgproject.neighbornest.domain.association;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Association}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociationRegistration implements Serializable {
    private LocalDate buildingDateOfBuild;
    private String buildingCadastral;
    private Integer buildingFloors;
    private Boolean buildingLift = false;
    private String buildingAddress;
    private String buildingPostIndex;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    @Size(max = 255)
    private String phone;
    @NotNull
    @Size(max = 255)
    private String email;
    @NotNull
    @Size(max = 255)
    private String regNumber;
    private int userId;
}