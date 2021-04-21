package com.parciallabv.parcialLabV.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
@Entity
@NoArgsConstructor
@Data
public class Jugador extends Persona {
        private double peso;
        private double altura;
        private Integer goles;
        private Integer minutosJugados;
        @OneToOne
        private Currency currency;
        private LocalDate fechaNacimiento;

        @Override
        public PersonType PersonType() {
                return PersonType.JUGADOR;
        }
}
