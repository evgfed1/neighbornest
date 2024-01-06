package com.antevgproject.neighbornest.domain.resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ResidentRepository extends JpaRepository<Resident, Integer> {

    @Query("select (count(r) > 0) from Resident r where upper (r.email) like upper(?1)")
    boolean existByEmail(String email);


    @Query("select (count(r) > 0) from Resident r where upper (r.phone) like upper(?1)")
    boolean existByPhone(String phone);

    @Query("select r from Resident r where r.phone = ?1")
    Optional<Resident> findByPhone(String phone);
}
