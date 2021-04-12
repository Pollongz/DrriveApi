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
@Table(name = "cars")
public class Car implements Serializable {

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

    @OneToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    @JsonBackReference(value = "carsDamages")
    private Set<Damage> damages;

    @OneToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    @JsonBackReference(value = "carsRefuelings")
    private Set<Refueling> refuelings;

    @OneToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    @JsonBackReference(value = "carsServices")
    private Set<Services> services;

    @ManyToOne
    @JsonManagedReference(value = "companyCars")
    @JoinColumn(name = "id_companies", nullable = false)
    private Company companies;
}
