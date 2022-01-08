package com.github.thomasandre84.orgchart.repository;

import com.github.thomasandre84.orgchart.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
