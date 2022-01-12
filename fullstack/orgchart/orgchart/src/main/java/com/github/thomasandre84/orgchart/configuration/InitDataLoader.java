package com.github.thomasandre84.orgchart.configuration;

import com.github.thomasandre84.orgchart.model.OrgUnit;
import com.github.thomasandre84.orgchart.model.Product;
import com.github.thomasandre84.orgchart.model.dto.EmployeeDto;
import com.github.thomasandre84.orgchart.service.EmployeeService;
import com.github.thomasandre84.orgchart.service.OrgUnitService;
import com.github.thomasandre84.orgchart.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Load initial Data at startup of the application.
 * For testing purpose only.
 */
//@Profile("dev")
@Configuration
public class InitDataLoader implements CommandLineRunner {
    private final ProductService productService;
    private final OrgUnitService orgUnitService;
    private final EmployeeService employeeService;

    public InitDataLoader(ProductService productService, OrgUnitService orgUnitService, EmployeeService employeeService) {
        this.productService = productService;
        this.orgUnitService = orgUnitService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadOrgUnits();
        loadProducts();
        loadEmployees();

    }

    private void loadEmployees() {
        var empl0 = new EmployeeDto("user0", "unit0", null, null);
        var empl1 = new EmployeeDto("user1", "unit1", "apple", "user0");
        var empl2 = new EmployeeDto("user2", "unit2", "orange", "user0");
        var empl3 = new EmployeeDto("user3", "unit1", "apple", "user1");

        employeeService.saveEmployee(empl0);
        employeeService.saveEmployee(empl1);
        employeeService.saveEmployee(empl2);
        employeeService.saveEmployee(empl3);

    }

    private void loadProducts() {
        Product prod0 = new Product();
        prod0.setName("apple");
        Product prod1 = new Product();
        prod1.setName("orange");
        Product prod2 = new Product();
        prod2.setName("pear");

        productService.saveProduct(prod0);
        productService.saveProduct(prod1);
        productService.saveProduct(prod2);
    }

    private void loadOrgUnits() {
        // initial OrgUnits
        OrgUnit org0 = new OrgUnit();
        org0.setName("unit0");

        OrgUnit org1 = new OrgUnit();
        org1.setName("unit1");

        OrgUnit org2 = new OrgUnit();
        org2.setName("unit2");
        orgUnitService.saveOrgUnit(org0);
        orgUnitService.saveOrgUnit(org1);
        orgUnitService.saveOrgUnit(org2);
    }
}
