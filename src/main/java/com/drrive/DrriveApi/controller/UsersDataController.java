package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.UsersData;
import com.drrive.DrriveApi.service.CompanyService;
import com.drrive.DrriveApi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usersData")
public class UsersDataController {

    private final UsersDataService usersDataService;
    private final CompanyService companyService;

    @Autowired
    public UsersDataController(UsersDataService usersDataService, CompanyService companyService) {
        this.usersDataService = usersDataService;
        this.companyService = companyService;
    }

    @GetMapping
    public List<UsersData> getUsers() {
        return usersDataService.getUsers();
    }

    @GetMapping(path = "/{idUserData}")
    public UsersData getOneUser(@PathVariable Integer idUserData) {
        return usersDataService.getUserById(idUserData);
    }

    @PostMapping
    public void addNewUser(@RequestBody UsersData usersData) {
        usersDataService.addNewUser(usersData);
    }

    @DeleteMapping(path = "/{idUserData}")
    public void deleteUser(@PathVariable Integer idUserData) {
        usersDataService.deleteUser(idUserData);
    }

    @PutMapping(path = "/{idUserData}")
    public String updateUser(@RequestBody UsersData usersData, @PathVariable Integer idUserData) {
        usersDataService.updateUser(usersData);
        return "UsersData edited successfully!";
    }
}