package com.parciallabv.parcialLabV.model;

public enum PersonType {
    JUGADOR("Persona"),
    REPRESENTANTE("Representante");

    private String description;

    PersonType(String description)
    {
        this.description=description;
    }

    public static PersonType find(final String value)
    {
        for (PersonType persons : values())
        {
            if (value.toString().equalsIgnoreCase(value))
            {
                return persons;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid argument for type Person"));
    }

    public String getDescription()
    {
        return description;
    }

}
