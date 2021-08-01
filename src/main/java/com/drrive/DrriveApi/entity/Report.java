package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reports")
    private Integer idReport;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "date")
    private LocalDateTime dateTime;
    private transient Integer idUsersData;

    @ManyToOne
    @JoinColumn(name = "id_users_data")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UsersData usersData;

    private transient Integer idCar;

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Car car;
}
