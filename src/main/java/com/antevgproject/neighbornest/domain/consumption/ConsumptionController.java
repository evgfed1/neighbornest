package com.antevgproject.neighbornest.domain.consumption;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumption")
public class ConsumptionController {

    @Resource
    private ConsumptionService consumptionService;

    @GetMapping("/period")
    public ConsumptionDto getConsumptionValues (@RequestParam Integer userId) {
        return consumptionService.getConsumptionValues(userId);
    }

}
