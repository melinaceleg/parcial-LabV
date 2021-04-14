package com.parciallabv.parcialLabV.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePerson",visible=true)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = Representante.class, name = "REPRESENTANTE"),
                @JsonSubTypes.Type(value = Jugador.class, name = "JUGADOR")
        }


)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Persona {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastname;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract PersonType PersonType();



}
