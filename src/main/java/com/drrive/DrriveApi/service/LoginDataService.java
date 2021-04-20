package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.dto.UserRegistrationDto;
import com.drrive.DrriveApi.entity.LoginData;
import com.drrive.DrriveApi.entity.Role;
import com.drrive.DrriveApi.rest.LoginDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LoginDataService implements com.drrive.DrriveApi.rest.LoginDataService {

    private LoginDataRepository loginDataRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public LoginDataService(LoginDataRepository loginDataRepository) {
        this.loginDataRepository = loginDataRepository;
    }

    @Override
    public LoginData save(UserRegistrationDto registrationDto) {
        LoginData user = new LoginData(registrationDto.getUsername(), passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getEmail(), Collections.singletonList(new Role("ADMIN")));

        return loginDataRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginData> user = loginDataRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                mapRolesToAuthorities(user.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }


//    private final LoginDataRepository loginDataRepository;
//
//    @Autowired
//    public LoginDataService(LoginDataRepository loginDataRepository) {
//        this.loginDataRepository = loginDataRepository;
//    }
//
//    public List<LoginData> getLoginData() {
//        return loginDataRepository.findAll();
//    }
//
//    public LoginData getLoginDataById(Integer idLoginData) {
//        return loginDataRepository.findById(idLoginData)
//                .orElseThrow(() -> new IllegalStateException(
//                        "User with id: " + idLoginData + "doesn't exist."
//                ));
//    }
//
//    public void deleteLoginData(Integer idLoginData) {
//        boolean exists = loginDataRepository.existsById(idLoginData);
//        if (!exists) {
//            throw new IllegalStateException("User with id: " + idLoginData + "doesn't exist.");
//        }
//        loginDataRepository.deleteById(idLoginData);
//    }
//
//    public void updateLoginData(LoginData loginData) {
//        LoginData existingLoginData = loginDataRepository.findById(loginData.getIdLoginData())
//                .orElseThrow(() -> new IllegalStateException(
//                        "User with id: " + loginData.getIdLoginData() + "doesn't exist."
//                ));
//        existingLoginData.setUsername(loginData.getUsername());
//        existingLoginData.setPassword(loginData.getPassword());
//        existingLoginData.setEmail(loginData.getEmail());
//        existingLoginData.setRole(loginData.getRole());
//
//        loginDataRepository.save(existingLoginData);
//    }
}
