package com.antevgproject.neighbornest.domain.resident;

import com.antevgproject.neighbornest.domain.user.User;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResidentService {

    @Resource
    public ResidentRepository residentRepository;

    @Resource
    public ResidentMapper residentMapper;

    public void registerNewResident(ResidentDto residentDto, User user) {

        Resident resident = residentMapper.residentFromResidentDto(residentDto);
        resident.setUser(user);
        residentRepository.save(resident);

    }

    public boolean validateByPhoneAndEmail(ResidentDto residentDto) {
        Optional<Resident> residentOptional = residentRepository.findByPhoneOrEmail(residentDto.getEmail(), residentDto.getPhone());
        ValidationService.isExistByPhoneAndEmail(residentOptional);
        return true;
    }
}
