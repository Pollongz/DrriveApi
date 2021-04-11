package com.drrive.DrriveApi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "damages")
public class Damage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_damages")
    private Integer idDamage;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cars")
    private Car cars;

    @OneToMany(mappedBy = "damages")
    private Set<Photo> photos;
}
