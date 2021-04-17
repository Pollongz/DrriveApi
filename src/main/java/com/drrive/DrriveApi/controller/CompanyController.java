package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Address;
import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.User;
import com.drrive.DrriveApi.service.AddressService;
import com.drrive.DrriveApi.service.CarService;
import com.drrive.DrriveApi.service.CompanyService;
import com.drrive.DrriveApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CarService carService;
    private final UserService userService;

    @Autowired
    public CompanyController(CompanyService companyService, CarService carService, UserService userService) {
        this.companyService = companyService;
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping
    public List<Company> getCar() {
        return companyService.getCompanies();
    }

    @GetMapping(path = "/{idCompany}")
    public Company getOneCompany(@PathVariable Integer idCompany) {
        return companyService.getCompaniesById(idCompany);
    }

    @GetMapping(path = "/{company}/cars")
    public List<Car> getCompanyCars(@PathVariable Company company) {
        return carService.getCompanyCars(company);
    }

    @GetMapping(path = "/{company}/employees")
    public List<User> getCompanyEmployees(@PathVariable Company company) {
        return userService.getCompanyEmployees(company);
    }

    @PostMapping
    public void addNewCompany(@RequestBody Company company) {
        companyService.addNewCompany(company);
    }

    @DeleteMapping(path = "/{idCompany}")
    public void deleteCompany(@PathVariable Integer idCompany) {
        companyService.deleteCompany(idCompany);
    }

    @PutMapping(path = "/{idCompany}")
    public String updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
        return "Company edited successfully!";
    }
}
