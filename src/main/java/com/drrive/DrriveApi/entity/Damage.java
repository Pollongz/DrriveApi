package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "damages")
public class Damage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_damages")
    private Integer idDamage;
    @Column(name = "description")
    private String description;
    @Column(name = "damage_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    private transient Integer reportedById;

    @ManyToOne
    @JoinColumn(name = "reported_by_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UsersData reportedBy;

    private transient Integer carId;

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Car car;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "damage", cascade = CascadeType.ALL)
    @JsonBackReference(value = "damagePhotos")
    private List<Photo> photos;
}
