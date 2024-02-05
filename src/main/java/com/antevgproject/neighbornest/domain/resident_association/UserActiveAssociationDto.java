package com.antevgproject.neighbornest.domain.resident_association;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ResidentAssociation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserActiveAssociationDto implements Serializable {
//    private Integer id;
    private Integer associationId;
    private String associationName;
    private String associationStatus;
    private Integer residentId;
    private Integer residentUserId;
    private Integer residentUserRoleId;   //user-admin  do Association Enter
    private String residentUserRoleName;
    private String residentStatus;
    private Integer roleId;
    private String roleName;   // moderator-owner-tenant  posle Association Enter
}