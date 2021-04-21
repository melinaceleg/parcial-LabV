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
    private List<Jugador> jugadores;
    private Double pesoDeLaBoveda;
    private Double montoTotal;

    @Override
    public PersonType PersonType() {
        return PersonType.REPRESENTANTE;
    }



    ///actualizo monto total con el monto recibido, realizando conversion a pesos
    public Double getMontoTotal()
    {
        Double total=0D;
        for (Jugador j:jugadores) {

            if (j.getCurrency().getCurrency().equals(TypeCurrency.EUROS))
                total += j.getCurrency().getMonto()*100;
            else if (j.getCurrency().getCurrency().equals(TypeCurrency.DOLARES))
                total += j.getCurrency().getMonto()*200;
        }
        return total;
    }
    //Actualizo peso de la boveda con la cantidad de billetes que llegaron, considerando la unidad de monto como cada billete

    public Double getpesoDeLaBoveda()
    {
        return getMontoTotal()/100;
    }
}
