package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_companies")
    private Integer idCompany;
    @Column(name = "name")
    private String name;
    @Column(name = "nip")
    private String nip;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    @JsonBackReference(value = "companyCars")
    private Set<Car> cars;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    @JsonBackReference(value = "companyUsers")
    private Set<User> users;
}