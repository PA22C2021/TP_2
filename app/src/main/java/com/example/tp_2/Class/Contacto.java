package com.example.tp_2.Class;

import java.io.Serializable;
import java.util.Date;

public class Contacto implements Serializable
{
    public Contacto(String nombre, String apellido, Telefono telefono, String email, String direccion, Date fechaNacimiento, DatosAdicionales datosAdicionales)
    {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Telefono = telefono;
        this.Email = email;
        this.Direccion = direccion;
        this.FechaNacimiento = fechaNacimiento;
        this.DatosAdicionales = datosAdicionales;
    }

    private String Nombre;
    private String Apellido;
    private Telefono Telefono;
    private String Email;
    private String Direccion;
    private Date FechaNacimiento;


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

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
}
