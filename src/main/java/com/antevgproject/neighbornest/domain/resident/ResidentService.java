package com.antevgproject.neighbornest.domain.resident;

import com.antevgproject.neighbornest.domain.user.User;
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

}
