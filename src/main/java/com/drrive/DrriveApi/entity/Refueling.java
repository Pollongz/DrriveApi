package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "refuelings")
public class Refueling implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_refuelings")
    private Integer idRefuel;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "fuel_quantity")
    private Float fuelQuantity;
    @Column(name = "fuel_cost")
    private Float fuelCost;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "refuel_date")
    private Date date;

    @ManyToOne
    @JsonBackReference(value = "carsRefuelings")
    @JoinColumn(name = "id_cars", insertable=false, updatable=false)
    private Car cars;
}
