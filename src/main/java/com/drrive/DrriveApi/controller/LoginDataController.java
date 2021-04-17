package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.LoginData;
import com.drrive.DrriveApi.service.LoginDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/login-data")
public class LoginDataController {

    private final LoginDataService loginDataService;

    @Autowired
    public LoginDataController(LoginDataService loginDataService) {
        this.loginDataService = loginDataService;
    }

    @GetMapping
    public List<LoginData> getLoginData() {
        return loginDataService.getLoginData();
    }

    @GetMapping(path = "/{idLoginData}")
    public LoginData getOneLoginData(@PathVariable Integer idLoginData) {
        return loginDataService.getLoginDataById(idLoginData);
    }

    @PostMapping
    public void addNewLoginData(@RequestBody LoginData loginData) {
        loginDataService.addNewLoginData(loginData);
    }

    @DeleteMapping(path = "/{idLoginData}")
    public void deleteLoginData(@PathVariable Integer idLoginData) {
        loginDataService.deleteLoginData(idLoginData);
    }

    @PutMapping(path = "/{idLoginData}")
    public String updateLoginData(@RequestBody LoginData loginData) {
        loginDataService.updateLoginData(loginData);
        return "User edited successfully!";
    }
}
