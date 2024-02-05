package com.antevgproject.neighbornest.domain.association;

import com.antevgproject.neighbornest.domain.resident_association.UserActiveAssociationDto;
import io.swagger.v3.oas.annotations.Operation;
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
    public List<ActiveAssociationsDto> getAllActiveAssociations() {
        return associationService.getActiveAssociations();
    }

    @GetMapping("/search2")
    @Operation(summary = "Show all active user's associations")
    public List<UserActiveAssociationDto> getUserActiveAssociations(@RequestParam Integer userId) {
        return associationService.getUserActiveAssociations(userId);
    }
}

