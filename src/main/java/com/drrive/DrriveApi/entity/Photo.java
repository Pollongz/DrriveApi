package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "photos")
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photos")
    private Integer idPhoto;
    @Column(name = "photo_url")
    private String photoUrl;

    private transient Integer damageId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_damage")
    private Damage damage;
}