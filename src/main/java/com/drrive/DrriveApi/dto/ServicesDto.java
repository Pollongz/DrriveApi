package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDto {

    private Integer idServices;
    private String serviceType;
    private Float ServiceCost;
    private Integer mileage;
    private Date date;
    private Integer car;
}
