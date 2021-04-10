package com.drrive.DrriveApi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cars")
    private Integer idCar;
    @Column(name = "brand_name")
    private String carBrand;
    @Column(name = "model_name")
    private String carModel;
    @Column(name = "manufacture_year")
    private Integer carManufactureYear;
    @Column(name = "type")
    private String carType;
    @Column(name = "engine_capacity")
    private String engineCapacity;
    @Column(name = "engine_power")
    private String enginePower;
    @Column(name = "plate_number")
    private String plateNumber;
    @Column(name = "is_taken")
    private Integer isTaken;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cars")
    private Set<Damage> damages;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cars")
    private Set<Refueling> refuelings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cars")
    private Set<Services> services;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "id_companies")
    private Company company;
}
