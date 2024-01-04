package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.domain.resident.Resident;
import com.antevgproject.neighbornest.domain.resident.ResidentDto;
import com.antevgproject.neighbornest.domain.resident.ResidentMapper;
import com.antevgproject.neighbornest.domain.resident.ResidentRepository;
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
    public ResidentMapper residentMapper;
    @Resource
    public UserRepository userRepository;
    @Resource
    public ResidentRepository residentRepository;

    public LoginDto login(String username, String password) {

        Optional<User> optionalUser = userRepository.findUserBy(username);
        User user = ValidationService.getValidUser(optionalUser);
        return userMapper.toLoginDto(user);
    }

    public void registerNewUser(ResidentDto residentDto) {
        User user = userMapper.userFromResidentDto(residentDto);
        user.setRole(new Role(2, "user"));
        userRepository.save(user);
        Resident resident = residentMapper.residentFromResidentDto(residentDto);
        resident.setUser(user);
        residentRepository.save(resident);

    }

    public ValidUserDto compareNewUser(String username, String phone, String email) {
        Optional<User> optionalUser = userRepository.findUserBy(username);
        User user = ValidationService.getValidUser(optionalUser);

        return userMapper.toValidUserDto(user);
    }
}
