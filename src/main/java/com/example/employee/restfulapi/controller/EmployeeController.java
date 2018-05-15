package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findOne(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/page/{page}/pageSize/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity geEmployeesByPage(@PathVariable int page, @PathVariable int pageSize){
        Pageable pageable = new PageRequest(page - 1, pageSize);

        Page result = employeeRepository.findAll(pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
