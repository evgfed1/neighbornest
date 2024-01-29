package com.antevgproject.neighbornest.domain.association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssociationRepository extends JpaRepository<Association, Integer> {

    @Query("select (count(a) > 0) from Association a where upper(a.name) = upper(?1)")
    boolean existByName(String name);

    @Query("select (count(a) > 0) from Association a where upper(a.regNumber) = upper(?1)")
    boolean existByRegNumber(String regNumber);

    @Query("select (count(a) > 0) from Association a where upper(a.email) = upper(?1)")
    boolean existByEmail(String email);

    @Query("select (count(a) > 0) from Association a where a.phone = ?1")
    boolean existByPhone(String phone);

    @Query("select a from Association a where upper(a.status) = upper(?1)")
    List<Association> findAllAssociationsByStatus(String status);
//    @Query("""
//            select a from Association a
//            where upper(a.name) = upper(?1) and upper(a.email) = upper(?2) and upper(a.regNumber) = upper(?3)""")
//    List<Association> someMethod(String name, String email, String regNumber);
}
