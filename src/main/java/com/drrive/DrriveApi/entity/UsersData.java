package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_data")
public class UsersData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users_data")
    private Integer idUserData;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    private transient Integer userId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    private transient Integer companyId;

    @ManyToOne
    @JoinColumn(name = "id_company")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usersData", cascade = CascadeType.ALL)
    @JsonBackReference(value = "usersReports")
    private List<Report> reports;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reportedBy", cascade = CascadeType.ALL)
    @JsonBackReference(value = "usersDamagesReported")
    private List<Damage> damages;
}
