package com.antevgproject.neighbornest.business.registration.dto;

import com.antevgproject.neighbornest.domain.association.Association;
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
public class AssociationDto implements Serializable {

    private LocalDate buildingDateOfBuild;
    private String buildingCadastral;
    private Integer buildingFloors;              //building
    private Boolean buildingLift = false;
    private String buildingAddress;
    private String buildingPostIndex;


    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    @Size(max = 255)
    private String phone;
    @NotNull                 //association
    @Size(max = 255)
    private String email;
    @NotNull
    @Size(max = 255)
    private String regNumber;


    private String roleName;
    private String username;     // user
    private String password;
}