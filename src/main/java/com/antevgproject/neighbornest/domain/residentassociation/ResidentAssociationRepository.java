package com.antevgproject.neighbornest.domain.residentassociation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResidentAssociationRepository extends JpaRepository<ResidentAssociation, Integer> {
    @Query("select r from ResidentAssociation r where r.resident.user.id = ?1")
    List<ResidentAssociation> findActiveUserAssociations(Integer id);
}