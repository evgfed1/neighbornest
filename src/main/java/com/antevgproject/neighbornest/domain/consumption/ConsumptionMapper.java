package com.antevgproject.neighbornest.domain.consumption;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsumptionMapper {
    @Mapping(source = "createdByResidentUserId", target = "user.id")
    Consumption toEntity(ConsumptionDto1 consumptionDto1);

    @Mapping(source = "user.id", target = "createdByResidentUserId")
    ConsumptionDto1 toDto(Consumption consumption);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "createdByResidentUserId", target = "user.id")
    Consumption partialUpdate(ConsumptionDto1 consumptionDto1, @MappingTarget Consumption consumption);
}