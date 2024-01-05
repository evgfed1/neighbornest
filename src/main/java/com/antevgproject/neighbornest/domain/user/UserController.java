package com.antevgproject.neighbornest.domain.user;


import com.antevgproject.neighbornest.domain.resident.ResidentDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public LoginDto login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/registration/user")
    public void registerNewUser(@RequestBody ResidentDto residentDto){
        userService.registerNewUser(residentDto);
    }

}
