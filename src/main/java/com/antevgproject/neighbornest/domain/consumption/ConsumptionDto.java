package com.antevgproject.neighbornest.domain.consumption;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link Consumption}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionDto implements Serializable {
    private Integer id;
    private Integer createdByResidentId;
    private BigDecimal hotWater;
    private BigDecimal coldWater;
    private BigDecimal electricity;
    private BigDecimal gas;
    @NotNull
    private LocalDate createdAt;
}