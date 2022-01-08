package com.github.thomasandre84.orgchart.configuration;

import com.github.thomasandre84.orgchart.model.OrgUnit;
import com.github.thomasandre84.orgchart.model.Product;
import com.github.thomasandre84.orgchart.service.EmployeeService;
import com.github.thomasandre84.orgchart.service.OrgUnitService;
import com.github.thomasandre84.orgchart.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
