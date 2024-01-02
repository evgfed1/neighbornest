package com.antevgproject.neighbornest.domain.building;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "date_of_build", nullable = false)
    private LocalDate dateOfBuild;

    @Size(max = 255)
    @NotNull
    @Column(name = "cadastral", nullable = false)
    private String cadastral;

    @NotNull
    @Column(name = "floors", nullable = false)
    private Integer floors;

    @NotNull
    @Column(name = "lift", nullable = false)
    private Boolean lift = false;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Size(max = 255)
    @Column(name = "post_index")
    private String postIndex;

}