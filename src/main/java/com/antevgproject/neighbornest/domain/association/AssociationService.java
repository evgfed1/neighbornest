package com.antevgproject.neighbornest.domain.association;

import com.antevgproject.neighbornest.domain.building.Building;
import com.antevgproject.neighbornest.domain.building.BuildingService;
import com.antevgproject.neighbornest.domain.resident.Resident;
import com.antevgproject.neighbornest.domain.resident.ResidentService;
import com.antevgproject.neighbornest.domain.residentassociation.ResidentAssociation;
import com.antevgproject.neighbornest.domain.residentassociation.ResidentAssociationRepository;
import com.antevgproject.neighbornest.domain.user.role.RoleService;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.antevgproject.neighbornest.constant.RoleConstants.MODERATOR;

@Service
@Slf4j
public class AssociationService {

    @Resource
    private BuildingService buildingService;
    @Resource
    private AssociationMapper associationMapper;
    @Resource
    private AssociationRepository associationRepository;
    @Resource
    private ResidentService residentService;
    @Resource
    private ResidentAssociationRepository residentAssociationRepository;
    @Resource
    private RoleService roleService;

    public void registerNewAssociation(AssociationRegistration associationRegistration) {

        validateAssociationDto(associationRegistration);
        Building building = buildingService.registerNewBuilding(associationRegistration);
        Association association = associationMapper.associationFromAssociationDto(associationRegistration);
        association.setStatus("A");

        association.setBuilding(building);
        Association savedAssociation = associationRepository.save(association);

        Resident resident = residentService.findByUserId(associationRegistration.getUserId());

        ResidentAssociation residentAssociation = new ResidentAssociation();
        residentAssociation.setAssociation(savedAssociation);
        residentAssociation.setResident(resident);

        residentAssociation.setRole(roleService.finByName(MODERATOR));
        residentAssociationRepository.save(residentAssociation);
    }

    public void validateAssociationDto(AssociationRegistration associationRegistration) {
        validateByName(associationRegistration.getName());
        validateByRegNumber(associationRegistration.getRegNumber());
        validateByEmail(associationRegistration.getEmail());
        validateByPhone(associationRegistration.getPhone());
    }

    private void validateByName(String name) {
        log.debug("Validate by name...");
        boolean existByName = associationRepository.existByName(name);
        ValidationService.isExistByName(existByName);
    }

    private void validateByRegNumber(String regNumber) {
        boolean existByRegNumber = associationRepository.existByRegNumber(regNumber);
        ValidationService.isExistByRegNumber(existByRegNumber);
    }

    private void validateByEmail(String email) {
        boolean existByEmail = associationRepository.existByEmail(email);
        ValidationService.isExistByEmail(existByEmail);
    }

    private void validateByPhone(String phone) {
        boolean existByPhone = associationRepository.existByPhone(phone);
        ValidationService.isExistByPhone(existByPhone);
    }

}
