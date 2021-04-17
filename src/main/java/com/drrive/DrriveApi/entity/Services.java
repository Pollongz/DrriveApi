package com.drrive.DrriveApi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Float ServiceCost;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "service_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;
}
