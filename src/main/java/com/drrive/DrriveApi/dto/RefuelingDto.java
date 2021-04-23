package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefuelingDto {

    private Integer idRefueling;
    private String fuelType;
    private Float fuelQuantity;
    private Float fuelCost;
    private Integer mileage;
    private Date date;
    private Integer car;
}
