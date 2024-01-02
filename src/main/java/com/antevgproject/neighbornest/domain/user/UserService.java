package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    public UserMapper userMapper;
    @Resource
    public  UserRepository userRepository;

    public LoginDto login(String username, String password) {

        Optional<User> optionalUser = userRepository.findUserBy(username, password);
        User user = ValidationService.getValidUser(optionalUser);
        return userMapper.toLoginDto(user);
    }

}
