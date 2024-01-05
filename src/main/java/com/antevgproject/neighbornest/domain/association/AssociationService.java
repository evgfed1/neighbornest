package com.antevgproject.neighbornest.domain.association;

import com.antevgproject.neighbornest.domain.building.Building;
import com.antevgproject.neighbornest.domain.building.BuildingMapper;
import com.antevgproject.neighbornest.domain.building.BuildingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AssociationService {

    @Resource
    public AssociationMapper associationMapper;
    @Resource
    public BuildingMapper buildingMapper;
    @Resource
    public BuildingRepository buildingRepository;
    @Resource
    public AssociationRepository associationRepository;

    public void registerNewAssociation(AssociationDto associationDto) {
        Association association = associationMapper.associationFromAssociationDto(associationDto);
        Building building = buildingMapper.buildingFromAssociationDto(associationDto);
        buildingRepository.save(building);
        association.setBuilding(building);
        associationRepository.save(association);
    }
}
