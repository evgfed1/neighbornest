package com.antevgproject.neighbornest.domain.residentassociation;

import com.antevgproject.neighbornest.domain.association.Association;
import com.antevgproject.neighbornest.domain.resident.Resident;
import com.antevgproject.neighbornest.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.antevgproject.neighbornest.constant.RoleConstants.MODERATOR;

@Service
public class ResidentAssociationService {
    @Resource
    public ResidentAssociationRepository residentAssociationRepository;
    @Resource
    public RoleService roleService;
    @Resource
    public ResidentAssociationMapper residentAssociationMapper;


    public void setParameters(Association savedAssociation, Resident resident) {
        ResidentAssociation residentAssociation = new ResidentAssociation();
        residentAssociation.setAssociation(savedAssociation);
        residentAssociation.setResident(resident);
        residentAssociation.setRole(roleService.finByName(MODERATOR));
        residentAssociationRepository.save(residentAssociation);
    }

    public List<UserActiveAssociationDto> getUserActiveAssociations(Integer userId) {
        List<ResidentAssociation> residentAssociationList = residentAssociationRepository.findActiveAssociationsByUserId(userId, "A");
        return residentAssociationMapper.toUserActiveAssociationsDto(residentAssociationList);
    }
}

