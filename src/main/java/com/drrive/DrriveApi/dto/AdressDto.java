package com.drrive.DrriveApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdressDto {

    private Integer idAddress;
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String buildingNumber;
}
