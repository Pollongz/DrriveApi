package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.LoginData;
import com.drrive.DrriveApi.rest.LoginDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginDataService {
    
    private final LoginDataRepository loginDataRepository;

    @Autowired
    public LoginDataService(LoginDataRepository loginDataRepository) {
        this.loginDataRepository = loginDataRepository;
    }

    public List<LoginData> getLoginData() {
        return loginDataRepository.findAll();
    }

    public LoginData getLoginDataById(Integer idLoginData) {
        return loginDataRepository.findById(idLoginData)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id: " + idLoginData + "doesn't exist."
                ));
    }

    public void addNewLoginData(LoginData loginData) {

        String encodedPassword = new BCryptPasswordEncoder().encode(loginData.getPassword());
        loginData.setPassword(encodedPassword);

        loginDataRepository.save(loginData);
    }

    public void deleteLoginData(Integer idLoginData) {
        boolean exists = loginDataRepository.existsById(idLoginData);
        if (!exists) {
            throw new IllegalStateException("User with id: " + idLoginData + "doesn't exist.");
        }
        loginDataRepository.deleteById(idLoginData);
    }

    public void updateLoginData(LoginData loginData) {
        LoginData existingLoginData = loginDataRepository.findById(loginData.getIdLoginData())
                .orElseThrow(() -> new IllegalStateException(
                        "User with id: " + loginData.getIdLoginData() + "doesn't exist."
                ));
        existingLoginData.setUsername(loginData.getUsername());
        existingLoginData.setPassword(loginData.getPassword());
        existingLoginData.setEmail(loginData.getEmail());
        existingLoginData.setPrivelage(loginData.getPrivelage());

        loginDataRepository.save(existingLoginData);
    }
}
