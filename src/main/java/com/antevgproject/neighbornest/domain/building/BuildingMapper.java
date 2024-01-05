package com.antevgproject.neighbornest.domain.building;

import com.antevgproject.neighbornest.domain.association.AssociationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuildingMapper {
    @Mapping(source = "buildingDateOfBuild", target = "dateOfBuild")
    @Mapping(source = "buildingCadastral", target = "cadastral")
    @Mapping(source = "buildingFloors", target = "floors")
    @Mapping(source = "buildingLift", target = "lift")
    @Mapping(source = "buildingAddress", target = "address")
    @Mapping(source = "buildingPostIndex", target = "postIndex")
    Building buildingFromAssociationDto(AssociationDto associationDto);
}
