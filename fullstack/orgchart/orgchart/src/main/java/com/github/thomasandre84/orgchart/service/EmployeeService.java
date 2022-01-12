package com.github.thomasandre84.orgchart.service;

import com.github.thomasandre84.orgchart.model.Employee;
import com.github.thomasandre84.orgchart.model.OrgUnit;
import com.github.thomasandre84.orgchart.model.Product;
import com.github.thomasandre84.orgchart.model.dto.EmployeeDto;
import com.github.thomasandre84.orgchart.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The Bean containing the logic for managing actions with Employees.
 */
@Service
public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;
    private final OrgUnitService orgUnitService;
    private final ProductService productService;

    public EmployeeService(EmployeeRepository employeeRepository,
                           OrgUnitService orgUnitService, ProductService productService) {
        this.employeeRepository = employeeRepository;
        this.orgUnitService = orgUnitService;
        this.productService = productService;
    }

    /**
     * Get all Employees.
     * @return
     */
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * Add a new Employee.
     * @param employeeDto
     * @return
     */
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapDtoToEntity(employeeDto);
        log.info("Going to save new Employee {} ", employeeDto.userId());
        Employee saved = employeeRepository.save(employee);
        return mapEntityToDto(saved);
    }

    private Employee mapDtoToEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setUserId(dto.userId());
        Optional<OrgUnit> orgUnit = orgUnitService.findByName(dto.orgUnit());
        orgUnit.ifPresent(employee::setOrgUnit);

        if (dto.product() != null) {
            Optional<Product> product = productService.findByName(dto.product());
            if (product.isPresent()){
                employee.setProduct(product.get());
            } else {
                throw new RuntimeException(dto.product());
            }
        }

        if (dto.supervisor() != null) {
            Optional<Employee> supervisor = employeeRepository.findById(dto.supervisor());
            if (supervisor.isPresent()) {
                employee.setSupervisor(supervisor.get());
            } else {
                throw new RuntimeException(dto.supervisor());
            }
        }

        return employee;
    }

    private EmployeeDto mapEntityToDto(Employee employee) {
        String productName = null;
        String superVisorId = null;
        if (employee.getProduct() != null) productName = employee.getProduct().getName();
        if (employee.getSupervisor() != null) superVisorId = employee.getSupervisor().getUserId();

        return new EmployeeDto(employee.getUserId(),
                employee.getOrgUnit().getName(),productName, superVisorId);
    }
}
