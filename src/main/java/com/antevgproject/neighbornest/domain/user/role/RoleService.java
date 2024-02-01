package com.antevgproject.neighbornest.domain.user.role;

import com.antevgproject.neighbornest.infrastructure.exception.GenericException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public Role finByName(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty()) {
            log.error("Role is not exist");
            throw new GenericException("Role is not exist", "Wrong role name");
        } else {
            return role.get();
        }
    }

}
