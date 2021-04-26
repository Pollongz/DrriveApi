package com.drrive.DrriveApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer idUserData;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer user;
    private Integer company;
}
