package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.UsersData;
import com.drrive.DrriveApi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usersData")
public class UsersDataController {

    private final UsersDataService usersDataService;

    @Autowired
    public UsersDataController(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
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
        return usersDataService.updateUser(usersData);
    }
}
