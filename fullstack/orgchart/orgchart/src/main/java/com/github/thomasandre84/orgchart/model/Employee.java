package com.github.thomasandre84.orgchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Employee Entity Class.
 */
@Entity
public class Employee {

    @Id
    @Column(length = 10)
    private String userId;

    @ManyToOne(optional = false)
    private OrgUnit orgUnit;

    @ManyToOne(optional = true)
    private Product product;

    @ManyToOne(optional = true)
    private Employee supervisor;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OrgUnit getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(OrgUnit orgUnit) {
        this.orgUnit = orgUnit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return userId != null ? userId.equals(employee.userId) : employee.userId == null;
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId='" + userId + '\'' +
                ", orgUnit=" + orgUnit +
                ", product=" + product +
                ", supervisor=" + supervisor +
                '}';
    }
}
