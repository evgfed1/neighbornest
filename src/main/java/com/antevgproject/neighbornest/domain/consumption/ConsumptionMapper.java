package com.antevgproject.neighbornest.domain.consumption;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsumptionMapper {

    @Mapping(source = "coldWater", target = "coldWater")
    @Mapping(source = "hotWater", target = "hotWater")
    @Mapping(source = "gas", target = "gas")
    @Mapping(source = "electricity", target = "electricity")
//    @Mapping(source = "createdAt", target = "createdAt")
    ConsumptionDto toConsumptionDto(Consumption consumption);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Consumption partialUpdate(ConsumptionDto consumptionDto, @MappingTarget Consumption consumption);
}