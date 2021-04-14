package com.parciallabv.parcialLabV.model;

public enum TypeCurrency {
    DOLARES("Dolares"),
    EUROS("Euros");

    private String description;

    TypeCurrency(String description)
    {
        this.description=description;
    }

    public static TypeCurrency find(final String value)
    {
        for (TypeCurrency currencies : values())
        {
            if (value.toString().equalsIgnoreCase(value))
            {
                return currencies;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid argument for type Person"));
    }

    public String getDescription()
    {
        return description;
    }
}
