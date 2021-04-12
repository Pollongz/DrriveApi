package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "photos")
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photos")
    private Integer idPhoto;
    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne
    @JsonBackReference(value = "damagesPhotos")
    @JoinColumn(name = "id_damages", insertable=false, updatable=false)
    private Damage damages;
}