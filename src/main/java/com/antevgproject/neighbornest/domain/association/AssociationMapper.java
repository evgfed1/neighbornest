package com.antevgproject.neighbornest.domain.association;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssociationMapper {

    @Mapping(source = "regNumber", target = "regNumber")
    @Mapping(constant = "A", target = "status")
    Association associationFromAssociationDto(AssociationDto associationDto);


    List<ActiveAssociationsDto> toDtoTest(List<Association> associationList);
}
