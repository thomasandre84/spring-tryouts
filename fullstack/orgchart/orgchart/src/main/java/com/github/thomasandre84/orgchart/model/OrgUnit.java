package com.github.thomasandre84.orgchart.model;

import javax.persistence.*;

@Entity
public class OrgUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15, unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrgUnit orgUnit = (OrgUnit) o;

        if (id != null ? !id.equals(orgUnit.id) : orgUnit.id != null) return false;
        return name != null ? name.equals(orgUnit.name) : orgUnit.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrgUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
