package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Integer idCompany;
    private String name;
    private String nip;
    private Integer address;
}
