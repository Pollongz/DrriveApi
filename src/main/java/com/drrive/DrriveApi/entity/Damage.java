package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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

    private transient Integer carId;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "damage", cascade = CascadeType.ALL)
    @JsonBackReference(value = "damagePhotos")
    private List<Photo> photos;
}
