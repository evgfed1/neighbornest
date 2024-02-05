package com.antevgproject.neighbornest.domain.association;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssociationMapper {

    @Mapping(source = "regNumber", target = "regNumber")
    Association associationFromAssociationDto(AssociationRegistration associationRegistration);


    List<ActiveAssociationsDto> toActiveAssociationDto(List<Association> associationList);
}
