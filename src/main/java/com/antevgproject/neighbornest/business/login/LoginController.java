package com.antevgproject.neighbornest.business.login;


import com.antevgproject.neighbornest.business.login.dto.LoginDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public LoginDto login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

}
