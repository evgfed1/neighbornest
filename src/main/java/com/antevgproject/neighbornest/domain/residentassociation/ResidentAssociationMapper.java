package com.antevgproject.neighbornest.domain.residentassociation;

import com.antevgproject.neighbornest.domain.residentassociation.UserActiveAssociationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResidentAssociationMapper {


    @Mapping(source = "association.id",target = "associationId")
    @Mapping(source = "association.name",target = "associationName")
    @Mapping(source = "association.status",target = "associationStatus")
    @Mapping(source = "resident.id",target = "residentId")
    @Mapping(source = "resident.user.id",target = "residentUserId")
    @Mapping(source = "resident.user.role.id",target = "residentUserRoleId")
    @Mapping(source = "resident.user.role.name",target = "residentUserRoleName")
    @Mapping(source = "resident.status",target = "residentStatus")
    @Mapping(source = "role.id",target = "roleId")
    @Mapping(source = "role.name",target = "roleName")
    UserActiveAssociationDto toUserActiveAssociationsDto(ResidentAssociation residentAssociationList);

    List<UserActiveAssociationDto> toUserActiveAssociationsDto(List<ResidentAssociation> residentAssociationList);


}
