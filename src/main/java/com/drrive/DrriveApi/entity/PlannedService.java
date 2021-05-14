package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "planned_services")
public class PlannedService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planned_services")
    private Integer idPlannedService;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    private transient Integer carId;

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Car car;
}
