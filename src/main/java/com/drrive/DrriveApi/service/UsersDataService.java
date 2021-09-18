package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.User;
import com.drrive.DrriveApi.entity.UsersData;
import com.drrive.DrriveApi.rest.CompanyRepository;
import com.drrive.DrriveApi.rest.UserRepository;
import com.drrive.DrriveApi.rest.UsersDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersDataService {
    
    private final UsersDataRepository usersDataRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Autowired
    public UsersDataService(UsersDataRepository usersDataRepository, CompanyRepository companyRepository, UserRepository userRepository) {
        this.usersDataRepository = usersDataRepository;
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public List<UsersData> getUsers() {
        return usersDataRepository.findAll();
    }

    public List<UsersData> getCompanyEmployees(Company company) {
        return usersDataRepository.findEmployeesFromCompany(company);
    }

    public UsersData getUsersData(User user) {
        return usersDataRepository.findUsersData(user);
    }

    public UsersData getUserById(Integer idUserData) {
        return usersDataRepository.findById(idUserData)
                .orElseThrow(() -> new IllegalStateException(
                        "UsersData with id: " + idUserData + "doesn't exist."
                ));
    }

    public UsersData addNewUser(UsersData usersData) {
        usersData.setCompany(companyRepository.getOne(usersData.getCompanyId()));
        usersData.setUser(userRepository.getOne(usersData.getUserId()));
        return usersDataRepository.save(usersData);
    }

    public void deleteUser(Integer idUserData) {
        boolean exists = usersDataRepository.existsById(idUserData);
        if (!exists) {
            throw new IllegalStateException("UsersData with id: " + idUserData + "doesn't exist.");
        }
        usersDataRepository.deleteById(idUserData);
    }

    public String updateUser(UsersData usersData) {
        UsersData existingUser = usersDataRepository.findById(usersData.getIdUserData())
                .orElseThrow(() -> new IllegalStateException(
                        "UsersData with id: " + usersData.getIdUserData() + " doesn't exist."
                ));
        existingUser.setFirstName(usersData.getFirstName());
        existingUser.setLastName(usersData.getLastName());
        existingUser.setPhoneNumber(usersData.getPhoneNumber());
        existingUser.setCompany(companyRepository.getOne(usersData.getCompanyId()));
        existingUser.setUser(userRepository.getOne(usersData.getUserId()));

        usersDataRepository.save(existingUser);
        return "UsersData edited successfully!";
    }
}
