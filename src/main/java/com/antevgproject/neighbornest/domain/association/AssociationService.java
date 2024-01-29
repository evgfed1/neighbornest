package com.antevgproject.neighbornest.domain.association;

import com.antevgproject.neighbornest.domain.building.Building;
import com.antevgproject.neighbornest.domain.building.BuildingService;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {

    @Resource
    public BuildingService buildingService;
    @Resource
    public AssociationMapper associationMapper;
    @Resource
    public AssociationRepository associationRepository;

    public void registerNewAssociation(AssociationDto associationDto) {

        validateAssociationDto(associationDto);
        buildingService.validateBuildingByAssociationDto(associationDto);

        Building building = buildingService.registerNewBuilding(associationDto);
        Association association = associationMapper.associationFromAssociationDto(associationDto);
        association.setBuilding(building);
        associationRepository.save(association);
    }

    public void validateAssociationDto(AssociationDto associationDto) {
        validateByName(associationDto.getName());
        validateByRegNumber(associationDto.getRegNumber());
        validateByEmail(associationDto.getEmail());
        validateByPhone(associationDto.getPhone());


//        associationRepository.someMethod(associationDto.getName(), associationDto.getEmail(), associationDto.getRegNumber());
//        iz repo berem list i ego uzhe po otdeljnosti validiruem, tk chem menshe zaprosov v DB tem luchwe.
    }

    private void validateByName(String name) {
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


    public List<ActiveAssociationsDto> getActiveAssociations() {
        List<Association> associationList = associationRepository.findAllActiveAssociations("A");
        return associationMapper.toDtoTest(associationList);
    }
}
