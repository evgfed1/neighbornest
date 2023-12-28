package com.antevgproject.neighbornest.domain.user;

import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    public  UserRepository userRepository;

    public User findUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password);
        return ValidationService.getValidUser(optionalUser);
    }
}
