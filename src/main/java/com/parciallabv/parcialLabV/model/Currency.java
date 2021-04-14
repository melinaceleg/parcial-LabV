package com.parciallabv.parcialLabV.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty
    private String Currency;
    private double Monto;

}
