package com.github.thomasandre84.orgchart.controller;

import com.github.thomasandre84.orgchart.model.OrgUnit;
import com.github.thomasandre84.orgchart.service.OrgUnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = OrgUnitController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrgUnitController {
    static final String BASE_URL = "/orgunits";
    private static final Logger log = LoggerFactory.getLogger(OrgUnitController.class);

    private final OrgUnitService orgUnitService;

    public OrgUnitController(OrgUnitService orgUnitService) {
        this.orgUnitService = orgUnitService;
    }

    @GetMapping
    public ResponseEntity<List<OrgUnit>> getAllOrgUnits() {
        try {
            return ResponseEntity.ok(orgUnitService.getAllOrgUnits());
        } catch (Exception e) {
            log.error("Error while Requesting OrgUnits ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrgUnit> addOrgUnit(@RequestBody OrgUnit orgUnit) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(orgUnitService.saveOrgUnit(orgUnit));
        } catch (Exception e) {
            log.error("Error while Adding a new OrgUnit ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
