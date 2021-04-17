package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCar() {
        return companyService.getCompanies();
    }

    @GetMapping(path = "/{idCompany}")
    public Company getOneCar(@PathVariable Integer idCompany) {
        return companyService.getCompaniesById(idCompany);
    }

    @PostMapping
    public void addNewCar(@RequestBody Company company) {
        companyService.addNewCompany(company);
    }

    @DeleteMapping(path = "/{idCompany}")
    public void deleteCar(@PathVariable Integer idCompany) {
        companyService.deleteCompany(idCompany);
    }

    @PutMapping(path = "/{idCompany}")
    public String updateCar(@RequestBody Company company) {
        companyService.updateCompany(company);
        return "Company edited successfully!";
    }
}
