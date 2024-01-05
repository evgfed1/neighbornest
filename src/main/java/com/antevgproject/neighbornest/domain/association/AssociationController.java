package com.antevgproject.neighbornest.domain.association;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssociationController {

    @Resource
    private AssociationService associationService;

    @PostMapping("/registration/association")
    public void registerNewAssociation(@RequestBody AssociationDto associationDto) {
        associationService.registerNewAssociation(associationDto);
    }

}