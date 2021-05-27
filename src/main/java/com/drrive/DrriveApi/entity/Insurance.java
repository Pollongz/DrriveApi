package com.drrive.DrriveApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "insurance_info")
public class Insurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insurance_info")
    private Integer idInsurance;
    @Column(name = "policy_number")
    private String policyNumber;
    @Column(name = "assistance_phone_number")
    private String assistanceNumber;
}
