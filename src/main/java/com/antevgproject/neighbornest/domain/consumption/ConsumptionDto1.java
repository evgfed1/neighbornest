package com.antevgproject.neighbornest.domain.consumption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Consumption}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionDto1 implements Serializable {
    private Integer id;
    private Integer createdByResidentUserId;
    private BigDecimal hotWater;
    private BigDecimal coldWater;
    private BigDecimal electricity;
    private BigDecimal gas;
}