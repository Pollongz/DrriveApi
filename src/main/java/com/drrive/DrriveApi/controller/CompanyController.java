package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.Post;
import com.drrive.DrriveApi.entity.UsersData;
import com.drrive.DrriveApi.service.CarService;
import com.drrive.DrriveApi.service.CompanyService;
import com.drrive.DrriveApi.service.PostService;
import com.drrive.DrriveApi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CarService carService;
    private final UsersDataService usersDataService;
    private final PostService postService;

    @Autowired
    public CompanyController(CompanyService companyService, CarService carService, UsersDataService usersDataService, PostService postService) {
        this.companyService = companyService;
        this.carService = carService;
        this.usersDataService = usersDataService;
        this.postService = postService;
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
    public List<UsersData> getCompanyEmployees(@PathVariable Company company) {
        return usersDataService.getCompanyEmployees(company);
    }

    @GetMapping(path = "/{company}/posts")
    public List<Post> getCompanyPosts(@PathVariable Company company) {
        return postService.getCompanyPosts(company);
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
        return companyService.updateCompany(company);
    }
}
