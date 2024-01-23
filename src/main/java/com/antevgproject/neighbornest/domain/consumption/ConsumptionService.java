package com.antevgproject.neighbornest.domain.consumption;

import com.antevgproject.neighbornest.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumptionService {

    @Resource
    public ConsumptionRepository consumptionRepository;
    @Resource
    public ConsumptionMapper consumptionMapper;


    public ConsumptionDto getConsumptionValues(Integer userId) {

        Optional<Consumption> optionalConsumption = consumptionRepository.findByUserId(userId);
        Consumption consumption = ValidationService.getValidConsumption(optionalConsumption);
        ConsumptionDto consumptionDto = consumptionMapper.toConsumptionDto(consumption);

        return consumptionDto;
    }
}
