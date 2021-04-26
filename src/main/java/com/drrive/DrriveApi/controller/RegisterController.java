//package com.drrive.DrriveApi.controller;
//
//import com.drrive.DrriveApi.dto.UserRegistrationDto;
//import com.drrive.DrriveApi.rest.LoginDataService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/register")
//public class RegisterController {
//
//    private LoginDataService loginDataService;
//
//    public RegisterController(LoginDataService loginDataService) {
//        this.loginDataService = loginDataService;
//    }
//
//    @ModelAttribute("usersData")
//    public UserRegistrationDto userRegistrationDto() {
//        return new UserRegistrationDto();
//    }
//
//    @GetMapping
//    public String showRegistrationForm() {
//        return "register";
//    }
//
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("usersData") UserRegistrationDto registrationDto) {
//        loginDataService.save(registrationDto);
//        return "redirect:/register?success";
//    }
//}
