package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "login_data")
public class LoginData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login_data")
    private Integer idLoginData;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "loginData")
    @JsonBackReference(value = "usersLogin")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "login_roles",
            joinColumns = @JoinColumn(name = "id_login_data"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Collection<Role> roles;

    public LoginData(String username, String password, String email, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
}
