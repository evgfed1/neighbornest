package com.antevgproject.neighbornest.domain.building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BuildingRepository extends JpaRepository<Building, Integer> {

    @Query("select (count(b) > 0) from Building b where upper(b.address) = upper(?1)")
    boolean existsByAddressIgnoreCase(String address);

    @Query("select (count(b) > 0) from Building b where upper(b.address) = upper(?1)")
    boolean existByAddress(String address);

    @Query("select (count(b) > 0) from Building b where upper(b.cadastral) = upper(?1)")
    boolean existByCadastral(String cadastral);
}
