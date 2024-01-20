package com.antevgproject.neighbornest.domain.consumption;

import com.antevgproject.neighbornest.domain.resident.Resident;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consumption")
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by_resident_id", nullable = false)
    private Resident createdByResident;

    @Column(name = "hot_water", precision = 8, scale = 3)
    private BigDecimal hotWater;

    @Column(name = "cold_water", precision = 8, scale = 3)
    private BigDecimal coldWater;

    @Column(name = "electricity", precision = 8, scale = 3)
    private BigDecimal electricity;

    @Column(name = "gas", precision = 8, scale = 3)
    private BigDecimal gas;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

}