package com.antevgproject.neighbornest.domain.consumption;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumption")
public class ConsumptionController {

    @Resource
    private ConsumptionService consumptionService;

    @GetMapping("/period")
    public ConsumptionDto getConsumptionValues(@RequestParam Integer userId) {
        return consumptionService.getConsumptionValues(userId);
    }

    @PostMapping("/send")
    public void saveConsumptionValues(@RequestBody ConsumptionDto consumptionDto) {
        consumptionService.saveConsumptionValues(consumptionDto);
    }
}
