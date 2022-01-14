package com.github.thomasandre84.orgchart.controller;

import com.github.thomasandre84.orgchart.model.dto.EmployeeDto;
import com.github.thomasandre84.orgchart.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.thomasandre84.orgchart.controller.EmployeeController.BASE_URL;

/**
 * Rest Controller for employees REST calls.
 */
@RestController
@RequestMapping(value = BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    static final String BASE_URL = "/employees";

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Get all Employees.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        log.info("Fetching data");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    /**
     * Add a new Employee.
     * @param employeeDto
     * @return
     */
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.saveEmployee(employeeDto));
    }
}
