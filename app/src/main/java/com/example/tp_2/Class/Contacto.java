package com.example.tp_2.Class;

import com.example.tp_2.Enum.NivelEstudio;
import com.example.tp_2.Enum.TipoTelefono;

import java.io.Serializable;
import java.util.Date;

public class Contacto implements Serializable
{
    public  Contacto(){};
    public Contacto(String nombre, String apellido, Telefono telefono, String email, String direccion, String fechaNacimiento, DatosAdicionales datosAdicionales)
    {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Telefono = telefono;
        this.Email = email;
        this.Direccion = direccion;
        this.FechaNacimiento = fechaNacimiento;
        this.DatosAdicionales = datosAdicionales;
    }

    private int Id;
    private String Nombre;
    private String Apellido;
    private Telefono Telefono;
    private String Email;
    private String Direccion;
    private String FechaNacimiento;


    private DatosAdicionales DatosAdicionales;

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Telefono getTelefono() {
        return Telefono;
    }

    public void setTelefono(Telefono telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public com.example.tp_2.Class.DatosAdicionales getDatosAdicionales() {
        return DatosAdicionales;
    }

    public void setDatosAdicionales(DatosAdicionales datosAdicionales) {
        DatosAdicionales = datosAdicionales;
    }

    @Override
    public String toString()
    {
        return this.Nombre + " " + this.Apellido + " - " + this.Email;
    }

    public String toCSV(){
        return Nombre + ";" +
        Apellido + ";" +
        Email + ";" +
        Direccion + ";" +
        FechaNacimiento + ";" +
        Telefono.toCSV() + ";" +
        DatosAdicionales.toCSV() + "\n";
    }

    public String getHeaderCSV(){
        return "Nombre;Apellido;Email;Direccion;FechaNacimiento;" + Telefono.getHeaderCSV() + ";" +  DatosAdicionales.getHeaderCSV() + "\n";
    }

    public static Contacto fromCsvToClass(String CSV){
        String values [] = CSV.split(";");

        Telefono tel = new Telefono(values[5], TipoTelefono.valueOf(values[6]));
        DatosAdicionales adds = new DatosAdicionales(NivelEstudio.valueOf(values[7]),
                values[8].equals("true"), values[9].equals("true"), values[10].equals("true"), values[11].equals("true"), values[12].equals("true"));
        return new Contacto(values[0], values[1], tel, values[2], values[3], values[4], adds);
    }
}
