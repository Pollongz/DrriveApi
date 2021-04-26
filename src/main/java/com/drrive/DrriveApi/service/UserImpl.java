//package com.drrive.DrriveApi.service;
//
//import com.drrive.DrriveApi.dto.UserRegistrationDto;
//import com.drrive.DrriveApi.entity.User;
//import com.drrive.DrriveApi.entity.Role;
//import com.drrive.DrriveApi.rest.LoginDataRepository;
//import com.drrive.DrriveApi.rest.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//
//@Service
//public class LoginDataImpl implements com.drrive.DrriveApi.rest.LoginDataService {
//
//    private LoginDataRepository loginDataRepository;
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public LoginDataImpl(LoginDataRepository loginDataRepository, RoleRepository roleRepository) {
//        this.loginDataRepository = loginDataRepository;
//        this.roleRepository = roleRepository;
//    }
//
////    @Override
////    public User save(User user) {
////
////        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
////
////        User usersData = new User(
////                user.getUsername(),
////                passwordEncoder.encode(user.getPassword()),
////                user.getEmail(),
////                user.setRoles(adminRole)
////        );
////
////        return loginDataRepository.save(usersData);
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> usersData = loginDataRepository.findByUsername(username);
//
//        usersData.orElseThrow(() -> new UsernameNotFoundException("UsersData " + username + " not found."));
//
//        return new org.springframework.security.core.userdetails.UsersData(
//                usersData.get().getUsername(),
//                usersData.get().getPassword(),
//                getAuthorities(usersData.get().getRoles()));
//    }
//
//
//    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        for (Role role: roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        }
//        return authorities;
//    }
//
//
////    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
////
////         Collection<? extends GrantedAuthority> authorities = roles.stream()
////                 .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
////                 .collect(Collectors.toList());
////
////         return authorities;
////    }
//
//
////    private final LoginDataRepository loginDataRepository;
////
////    @Autowired
////    public LoginDataService(LoginDataRepository loginDataRepository) {
////        this.loginDataRepository = loginDataRepository;
////    }
////
////    public List<User> getLoginData() {
////        return loginDataRepository.findAll();
////    }
////
////    public User getLoginDataById(Integer idLoginData) {
////        return loginDataRepository.findById(idLoginData)
////                .orElseThrow(() -> new IllegalStateException(
////                        "UsersData with id: " + idLoginData + "doesn't exist."
////                ));
////    }
////
////    public void deleteLoginData(Integer idLoginData) {
////        boolean exists = loginDataRepository.existsById(idLoginData);
////        if (!exists) {
////            throw new IllegalStateException("UsersData with id: " + idLoginData + "doesn't exist.");
////        }
////        loginDataRepository.deleteById(idLoginData);
////    }
////
////    public void updateLoginData(User user) {
////        User existingLoginData = loginDataRepository.findById(user.getIdLoginData())
////                .orElseThrow(() -> new IllegalStateException(
////                        "UsersData with id: " + user.getIdLoginData() + "doesn't exist."
////                ));
////        existingLoginData.setUsername(user.getUsername());
////        existingLoginData.setPassword(user.getPassword());
////        existingLoginData.setEmail(user.getEmail());
////        existingLoginData.setRole(user.getRole());
////
////        loginDataRepository.save(existingLoginData);
////    }
//}
