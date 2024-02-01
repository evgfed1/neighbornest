package com.antevgproject.neighbornest.domain.building;

import com.antevgproject.neighbornest.domain.association.AssociationRegistration;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuildingService {

    public final BuildingMapper buildingMapper;
    public final BuildingRepository buildingRepository;


    public Building registerNewBuilding(AssociationRegistration associationRegistration) {
        validateBuildingByAssociationDto(associationRegistration);
        Building building = buildingMapper.buildingFromAssociationDto(associationRegistration);
        return buildingRepository.save(building);
    }

    public void validateBuildingByAssociationDto(AssociationRegistration associationRegistration) {
        validateByAddress(associationRegistration.getBuildingAddress());
        validateByCadastral(associationRegistration.getBuildingCadastral());
    }

    private void validateByAddress(String address) {
        boolean existByAddress = buildingRepository.existByAddress(address);
        ValidationService.isExistByAddress(existByAddress);
    }

    private void validateByCadastral(String cadastral) {
        boolean existByCadastral = buildingRepository.existByCadastral(cadastral);
        ValidationService.isExistByCadastral(existByCadastral);
    }

}
