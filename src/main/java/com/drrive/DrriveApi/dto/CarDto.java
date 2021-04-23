package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Integer idCar;
    private String carBrand;
    private String carModel;
    private Integer carManufactureYear;
    private String carType;
    private String engineCapacity;
    private String enginePower;
    private String plateNumber;
    private Integer isTaken;
    private Integer company;
}
