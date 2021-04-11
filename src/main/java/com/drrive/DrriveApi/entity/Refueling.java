package com.drrive.DrriveApi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "refuelings")
public class Refueling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "id_cars", insertable=false, updatable=false)
    private Car cars;
}
