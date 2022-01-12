package com.github.thomasandre84.orgchart.model.dto;

/**
 * Abstraction of Employees for Rest Clients.
 */
public record EmployeeDto(String userId, String orgUnit, String product, String supervisor) {
}
