package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_car", cascade = CascadeType.ALL)
    @JsonBackReference(value = "carDamages")
    private Set<Damage> damages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_car")
    @JsonBackReference(value = "carRefuelings")
    private Set<Refueling> refuelings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_car")
    @JsonBackReference(value = "carServices")
    private Set<Services> services;

    @ManyToOne
    @JoinColumn(name = "id_company")
    @JsonIgnore
    private transient Company company;

    private Integer id_company;
}
