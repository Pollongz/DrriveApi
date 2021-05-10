package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.*;
import com.drrive.DrriveApi.service.UserService;
import com.drrive.DrriveApi.service.UsersDataService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;
    private UsersDataService usersDataService;

    public UserController(UserService userService, UsersDataService usersDataService) {
        this.userService = userService;
        this.usersDataService = usersDataService;
    }

    @GetMapping
    public String getCurrentUser(@AuthenticationPrincipal Object user) {

        user = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        return user.toString();
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(path = "/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping(path = "/{user}/usersdata")
    public UsersData getUsersData(@PathVariable User user) {
        return usersDataService.getUsersData(user);
    }
}
