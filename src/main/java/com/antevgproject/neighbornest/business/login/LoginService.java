package com.antevgproject.neighbornest.business.login;

import com.antevgproject.neighbornest.business.login.dto.LoginDto;
import com.antevgproject.neighbornest.domain.user.User;
import com.antevgproject.neighbornest.domain.user.UserMapper;
import com.antevgproject.neighbornest.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserMapper userMapper;

    @Resource
    private UserService userService;

    public LoginDto login(String username, String password) {
        User user = userService.findUserBy(username, password);
        return userMapper.toLoginDto(user);
    }
}
