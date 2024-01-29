package com.antevgproject.neighbornest.domain.association;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/association")
public class AssociationController {

    @Resource
    private AssociationService associationService;

    @PostMapping("/registration")
    public void registerNewAssociation(@RequestBody AssociationDto associationDto) {
        associationService.registerNewAssociation(associationDto);
    }

    @GetMapping("/search")
    public List<Association> getAllAvailableAssociations(String status) {
        return associationService.getAvailableAssociations(status);
    }
}

