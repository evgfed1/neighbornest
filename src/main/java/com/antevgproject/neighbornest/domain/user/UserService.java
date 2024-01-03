package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.domain.Status;
import com.antevgproject.neighbornest.domain.resident.Resident;
import com.antevgproject.neighbornest.domain.resident.ResidentDto;
import com.antevgproject.neighbornest.domain.resident.ResidentMapper;
import com.antevgproject.neighbornest.domain.resident.ResidentRepository;
import com.antevgproject.neighbornest.domain.user.role.Role;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.antevgproject.neighbornest.domain.Status.ACTIVE;

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

        Optional<User> optionalUser = userRepository.findUserBy(username, password);
        User user = ValidationService.getValidUser(optionalUser);
        return userMapper.toLoginDto(user);
    }

    public void registerNewUser(ResidentDto residentDto) {
        User user = userMapper.userFromResidentDto(residentDto);
        user.setRole(new Role(2, "user"));
        userRepository.save(user);
        Resident resident = residentMapper.residentFromResidentDto(residentDto);
//        resident.setStatus(ACTIVE);
        residentRepository.save(resident);

    }
}
