package com.antevgproject.neighbornest.domain.building;

import com.antevgproject.neighbornest.domain.association.AssociationDto;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Resource
    public BuildingMapper buildingMapper;
    @Resource
    public BuildingRepository buildingRepository;


    public Building registerNewBuilding(AssociationDto associationDto) {
        Building building = buildingMapper.buildingFromAssociationDto(associationDto);
        buildingRepository.save(building);
        return building;
    }

    public void validateBuildingByAssociationDto(AssociationDto associationDto) {
        validateByAddress(associationDto.getBuildingAddress());
        validateByCadastral(associationDto.getBuildingCadastral());
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
