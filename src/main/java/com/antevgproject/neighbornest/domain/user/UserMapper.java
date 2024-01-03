package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.domain.resident.ResidentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

@Mapping(source = "id", target = "userId")
@Mapping(source = "role.name", target = "roleName")
    LoginDto toLoginDto(User user);


@Mapping(source = "userUsername", target = "username")
@Mapping(source = "userPassword", target = "password")
    User userFromResidentDto(ResidentDto residentDto);
}