package com.antevgproject.neighbornest.domain.consumption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConsumptionRepository extends JpaRepository<Consumption, Integer> {

    @Query("select c from Consumption c where c.createdByResident.user.id = ?1")
    Optional<Consumption> findByUserId(Integer id);
}