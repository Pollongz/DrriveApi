package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_companies")
    private Integer idCompany;
    @Column(name = "name")
    private String name;
    @Column(name = "nip")
    private String nip;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private Set<Car> cars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private Set<User> users;
}