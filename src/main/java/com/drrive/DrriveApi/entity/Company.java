package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @OneToOne
    @JoinColumn(name = "id_address")
    @JsonBackReference(value = "companyAddress")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    @JsonManagedReference(value = "companyCars")
    private Set<Car> cars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    @JsonManagedReference(value = "companyUsers")
    private Set<User> users;
}