package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_users")
    private Integer idUser;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(targetEntity = UserData.class)
    @JoinColumn(name = "id_users_data")
    private UserData usersData;

    @ManyToOne(optional=false)
    @JoinColumn(name = "id_companies", insertable=false, updatable=false)
    private Company companies;
}
