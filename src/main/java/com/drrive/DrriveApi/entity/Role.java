package com.drrive.DrriveApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Integer idRoles;
    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Collection<LoginData> loginData;

    public Role(String role) {
        this.role = role;
    }
}
