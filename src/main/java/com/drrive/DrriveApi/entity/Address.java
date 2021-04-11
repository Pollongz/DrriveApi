package com.drrive.DrriveApi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Integer idAddress;
    @Column(name = "country")
    private String country;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building_number")
    private String buildingNumber;
}
