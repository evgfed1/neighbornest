package com.antevgproject.neighbornest.domain.consumption;

import org.springframework.stereotype.Service;

@Service

public class ConsumptionService {
    public ConsumptionDto getConsumptionValues(int userId) {

//        1) vernutj residentId po userId


//        2) vernutj consumptionId cherez residentId
//        3) vernutj consumption na fron-end
        Consumption consumption = consumptionMapper.toConsumptionDto(consumption);
    }
}
