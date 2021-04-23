package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageDto {

    private Integer idDamage;
    private String description;
    private Integer car;
}
