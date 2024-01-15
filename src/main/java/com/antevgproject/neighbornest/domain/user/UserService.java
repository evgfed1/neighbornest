package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.domain.resident.Resident;
import com.antevgproject.neighbornest.domain.resident.ResidentDto;
import com.antevgproject.neighbornest.domain.resident.ResidentService;
import com.antevgproject.neighbornest.domain.user.role.Role;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    public UserMapper userMapper;

    @Resource
    public UserRepository userRepository;

    @Resource
    public ResidentService residentService;


    public LoginDto login(String username, String password) {

        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        User user = ValidationService.getValidUser(optionalUser);
        Resident resident = residentService.findByUserId(user.getId());
        LoginDto loginDto = userMapper.toLoginDto(user);
        loginDto.setFirstName(resident.getFirstName());
        loginDto.setLastName(resident.getLastName());

        return loginDto;
    }

    public LoginDto registerNewUser(ResidentDto residentDto) {

        Optional<User> optionalUser = userRepository.findByUsername(residentDto.getUserUsername());
        validateResidentDto(residentDto, optionalUser);
        User user = userMapper.userFromResidentDto(residentDto);
        user.setRole(new Role(2, "user"));
        userRepository.save(user);
        residentService.registerNewResident(residentDto, user);
        return getLoginDto(user);
    }

    private LoginDto getLoginDto(User user) {
        LoginDto loginDto = userMapper.toLoginDto(user);
        Resident resident = residentService.findByUserId(user.getId());
        loginDto.setFirstName(resident.getFirstName());
        loginDto.setLastName(resident.getLastName());
        return loginDto;
    }

    private void validateResidentDto(ResidentDto residentDto, Optional<User> optionalUser) {
        ValidationService.isExistByUsername(optionalUser);
        residentService.validateByPhoneAndEmail(residentDto);
    }

}
