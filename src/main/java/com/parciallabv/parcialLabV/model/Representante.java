package com.parciallabv.parcialLabV.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Representante extends Persona {
    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    private List<Persona> jugadores;
    private Double pesoDeLaBoveda;
    private double montoTotal;

    @Override
    public PersonType PersonType() {
        return PersonType.REPRESENTANTE;
    }

    //Actualizo peso de la boveda con la cantidad de billetes que llegaron, considerando la unidad de monto como cada billete
    public void actualizarPeso(Double peso)
    {
        pesoDeLaBoveda = pesoDeLaBoveda + peso;
    }

    ///actualizo monto total con el monto recibido, realizando conversion a pesos
    public void actualizarMontoTotal(double monto, String typeCurrency)
    {
        if (typeCurrency.equals(TypeCurrency.EUROS))
            montoTotal = montoTotal + monto*100;
        else
            if (typeCurrency.equals(TypeCurrency.DOLARES))
                montoTotal = montoTotal + monto*200;

    }
}
