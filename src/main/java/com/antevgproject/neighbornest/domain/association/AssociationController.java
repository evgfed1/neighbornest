package com.antevgproject.neighbornest.domain.association;

import com.antevgproject.neighbornest.domain.residentassociation.UserActiveAssociationDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/search/all")
    public List<ActiveAssociationsDto> getAllActiveAssociations() {
        return associationService.getActiveAssociations();
    }

    @GetMapping("/search/users")
    @Operation(summary = "Show all active user's associations")
    public List<UserActiveAssociationDto> getUserActiveAssociations(@RequestParam Integer userId) {
        return associationService.getUserActiveAssociations(userId);
    }
}
