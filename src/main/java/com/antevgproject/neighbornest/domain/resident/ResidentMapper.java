package com.antevgproject.neighbornest.domain.resident;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResidentMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthdate", target = "birthdate")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(constant = "A", target = "status")
    Resident residentFromResidentDto(ResidentDto residentDto);

}

