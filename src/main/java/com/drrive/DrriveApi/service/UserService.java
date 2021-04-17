package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.User;
import com.drrive.DrriveApi.rest.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id: " + idUser + "doesn't exist."
                ));
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer idUser) {
        boolean exists = userRepository.existsById(idUser);
        if (!exists) {
            throw new IllegalStateException("User with id: " + idUser + "doesn't exist.");
        }
        userRepository.deleteById(idUser);
    }

    public void updateUser(User user) {
        User existingUser = userRepository.findById(user.getIdUser())
                .orElseThrow(() -> new IllegalStateException(
                        "User with id: " + user.getIdUser() + " doesn't exist."
                ));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setLoginData(user.getLoginData());

        userRepository.save(existingUser);
    }
}
