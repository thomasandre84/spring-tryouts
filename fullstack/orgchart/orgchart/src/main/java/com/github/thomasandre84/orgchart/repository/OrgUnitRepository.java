package com.github.thomasandre84.orgchart.repository;

import com.github.thomasandre84.orgchart.model.OrgUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgUnitRepository extends JpaRepository<OrgUnit, Long> {
    Optional<OrgUnit> findByName(String name);
}
