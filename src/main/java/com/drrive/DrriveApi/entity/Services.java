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
@Table(name = "services")
public class Services implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_services")
    private Integer idServices;
    @Column(name = "service_type")
    private String serviceType;
    @Column(name = "service_cost")
    private Float fuelCost;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "service_date")
    private Date date;

    @ManyToOne
    @JsonBackReference(value = "carsServices")
    @JoinColumn(name = "id_cars", insertable=false, updatable=false)
    private Car cars;
}
