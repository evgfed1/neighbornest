package com.antevgproject.neighbornest.domain.resident_association;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentAssociationService {

    @Resource
    public ResidentAssociationRepository residentAssociationRepository;
    @Resource
    public ResidentAssociationMapper residentAssociationMapper;


    public List<UserActiveAssociationDto> getUserActiveAssociations(Integer userId) {
        List<ResidentAssociation> residentAssociationList = residentAssociationRepository.findActiveUserAssociations(userId);

        return residentAssociationMapper.toUserActiveAssociationsDto(residentAssociationList);
    }
}

