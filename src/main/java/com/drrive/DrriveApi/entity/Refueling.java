package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refuelings")
public class Refueling implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_refuelings")
    private Integer idRefueling;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "fuel_quantity")
    private Float fuelQuantity;
    @Column(name = "fuel_cost")
    private Float fuelCost;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "refuel_date")
    @Temporal(value = TemporalType.DATE)
    private Date date;

    private transient Integer carId;

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Car car;
}
