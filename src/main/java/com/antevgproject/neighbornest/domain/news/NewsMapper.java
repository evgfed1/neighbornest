package com.antevgproject.neighbornest.domain.news;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NewsMapper {

    @Mapping(source = "content", target = "content")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "publishDate", target = "publishDate")
    @Mapping(source = "title", target = "title")
    @Mapping(constant = "A", target = "status")
    News newsFromNewsDTO(NewsDTO newsDTO);
}
