package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {

    private Integer idPhoto;
    private String photoUrl;
    private Integer damage;
}
