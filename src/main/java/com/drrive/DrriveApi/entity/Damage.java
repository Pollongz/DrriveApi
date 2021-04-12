package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "damages")
public class Damage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_damages")
    private Integer idDamage;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference(value = "carsDamages")
    @JoinColumn(name = "id_cars", insertable=false, updatable=false)
    private Car cars;

    @OneToMany(mappedBy = "damages")
    @JsonBackReference(value = "damagesPhotos")
    private Set<Photo> photos;
}
