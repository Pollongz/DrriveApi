package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.User;
import com.drrive.DrriveApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{idUser}")
    public User getOneUser(@PathVariable Integer idUser) {
        return userService.getUserById(idUser);
    }

    @PostMapping
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "/{idUser}")
    public void deleteUser(@PathVariable Integer idUser) {
        userService.deleteUser(idUser);
    }

    @PutMapping(path = "/{idUser}")
    public String updateUser(@RequestBody User user, @PathVariable Integer idUser) {
        userService.updateUser(user);
        return "User edited successfully!";
    }
}
