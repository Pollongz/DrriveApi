package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserImpl implements UserDetails {

    private User user;

    public UserImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        this.user.getRoleList().forEach( role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public UserImpl(UserRepository userRepository, RoleRepository roleRepository) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//    }
//
//    @Override
//    public User save(User user) {
//
//        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//
//        User user1 = new User(
//                user.getUsername(),
//                passwordEncoder.encode(user.getPassword()),
//                user.getEmail(),
//                user.setRole(new Role("ROLE_ADMIN")),
//                user.getRoleId(new Role("ROLE_ADMIN"))
//        );
//
//        return userRepository.save(user);
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        return getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
//                .collect(Collectors.toList());
//    }

//    private final LoginDataRepository loginDataRepository;
//
//    @Autowired
//    public LoginDataService(LoginDataRepository loginDataRepository) {
//        this.loginDataRepository = loginDataRepository;
//    }
//
//    public List<User> getLoginData() {
//        return loginDataRepository.findAll();
//    }
//
//    public User getLoginDataById(Integer idLoginData) {
//        return loginDataRepository.findById(idLoginData)
//                .orElseThrow(() -> new IllegalStateException(
//                        "UsersData with id: " + idLoginData + "doesn't exist."
//                ));
//    }
//
//    public void deleteLoginData(Integer idLoginData) {
//        boolean exists = loginDataRepository.existsById(idLoginData);
//        if (!exists) {
//            throw new IllegalStateException("UsersData with id: " + idLoginData + "doesn't exist.");
//        }
//        loginDataRepository.deleteById(idLoginData);
//    }
//
//    public void updateLoginData(User user) {
//        User existingLoginData = loginDataRepository.findById(user.getIdLoginData())
//                .orElseThrow(() -> new IllegalStateException(
//                        "UsersData with id: " + user.getIdLoginData() + "doesn't exist."
//                ));
//        existingLoginData.setUsername(user.getUsername());
//        existingLoginData.setPassword(user.getPassword());
//        existingLoginData.setEmail(user.getEmail());
//        existingLoginData.setRole(user.getRole());
//
//        loginDataRepository.save(existingLoginData);
//    }
}
