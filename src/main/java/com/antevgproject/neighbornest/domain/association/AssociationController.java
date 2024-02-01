package com.antevgproject.neighbornest.domain.association;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/association")
@Slf4j
public class AssociationController {

    @Resource
    private AssociationService associationService;

    @PostMapping("/registration")
    public void registerNewAssociation(@RequestBody AssociationRegistration associationRegistration) {
        log.info("Registration form : {}", associationRegistration);
        associationService.registerNewAssociation(associationRegistration);
    }
}
