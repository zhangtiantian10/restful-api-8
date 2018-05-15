package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllCompanies() {
        List<Company> companies = companyRepository.findAll();

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCompanyById(@PathVariable Long id) {
        Company company = companyRepository.findOne(id);

        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/employees", method = RequestMethod.GET)
    public ResponseEntity getEmployeesByCompanyId(@PathVariable Long id){
        Company company = companyRepository.findOne(id);

        return new ResponseEntity<>(company.getEmployees(), HttpStatus.OK);
    }
}
