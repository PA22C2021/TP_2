package com.example.tp_2.Class;

import com.example.tp_2.Enum.TipoTelefono;

import java.io.Serializable;

public class Telefono implements Serializable
{
    public Telefono(String numero, TipoTelefono tipoTelefono)
    {
        this.Numero = numero;
        this.TipoTelefono = tipoTelefono;
    }

    private String Numero;
    private TipoTelefono TipoTelefono;
    
    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String toCSV(){
        return Numero + ";" +
        TipoTelefono;
    }

    public String getHeaderCSV(){
        return "Numero;TipoTelefono";
    }
}
