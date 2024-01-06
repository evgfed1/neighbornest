package com.antevgproject.neighbornest.domain.resident;

import com.antevgproject.neighbornest.domain.user.User;
import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

    public void validateByPhoneAndEmail(ResidentDto residentDto) {
        validateByPhone(residentDto.getPhone());
        validateByEmail(residentDto.getEmail());
    }

    private void validateByPhone(String phone) {
        boolean existByPhone = residentRepository.existByPhone(phone);
        ValidationService.isExistByPhone(existByPhone);
    }

    private void validateByEmail(String email) {
        boolean existByEmail = residentRepository.existByEmail(email);
        ValidationService.isExistByEmail(existByEmail);
    }

}
