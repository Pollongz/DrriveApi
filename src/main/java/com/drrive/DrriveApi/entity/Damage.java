package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonIgnore
    private transient Car car;

    private Integer id_car;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_damage", cascade = CascadeType.ALL)
    @JsonBackReference(value = "damagePhotos")
    private Set<Photo> photos;
}
