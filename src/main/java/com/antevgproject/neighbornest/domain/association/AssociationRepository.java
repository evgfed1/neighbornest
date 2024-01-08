package com.antevgproject.neighbornest.domain.association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssociationRepository extends JpaRepository<Association, Integer> {



    @Query("select (count(a) > 0) from Association a where upper(a.name) = upper(?1)")
    boolean existByName(String name);

    @Query("select (count(a) > 0) from Association a where upper(a.regNumber) = upper(?1)")
    boolean existByRegNumber(String regNumber);

    @Query("select (count(a) > 0) from Association a where upper(a.email) = upper(?1)")
    boolean existByEmail(String email);
}
