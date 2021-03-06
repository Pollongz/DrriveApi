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
@Table(name = "services")
public class Services implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_services")
    private Integer idServices;
    @Column(name = "description")
    private String description;
    @Column(name = "service_cost")
    private Float ServiceCost;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "service_date")
    @Temporal(value = TemporalType.DATE)
    private Date date;

    private transient Integer carId;

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Car car;
}
