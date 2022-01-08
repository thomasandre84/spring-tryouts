package com.github.thomasandre84.orgchart.service;

import com.github.thomasandre84.orgchart.model.OrgUnit;
import com.github.thomasandre84.orgchart.repository.OrgUnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgUnitService {
    private static final Logger log = LoggerFactory.getLogger(OrgUnitService.class);

    private final OrgUnitRepository orgUnitRepository;

    public OrgUnitService(OrgUnitRepository orgUnitRepository) {
        this.orgUnitRepository = orgUnitRepository;
    }

    public OrgUnit saveOrgUnit(OrgUnit orgUnit) {
        log.info("Going to save: {}", orgUnit);
        OrgUnit saved = orgUnitRepository.save(orgUnit);
        return saved;
    }

    public List<OrgUnit> getAllOrgUnits() {
        return orgUnitRepository.findAll();
    }

    public Optional<OrgUnit> findByName(String name) {
        return orgUnitRepository.findByName(name);
    }
}
