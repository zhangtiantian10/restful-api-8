package com.example.employee.restfulapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private Integer employeesNumber;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Employee> employees;

    public Company() {
    }

    public Company(String companyName, Integer employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
