package com.antevgproject.neighbornest.domain.user;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    private UserService userService;



    @GetMapping("/login")
    public LoginDto login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

}
