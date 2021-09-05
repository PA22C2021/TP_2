package com.example.tp_2.Class;

import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Almacenamiento
{
    private final static String FileName = "contactos.txt";

    public Almacenamiento()
    {
    }

    public void Guardar(Contacto contacto)
    {
        // TODO: Agregar contacto al archivo.
    }

    public ArrayList<Contacto> Cargar()
    {
        ArrayList<Contacto> contactoList = new ArrayList<Contacto>();

        // TODO: Leer los contactos del archivo.
        contactoList.add(new Contacto("PRUEBA", "PRUEBA", null, "PRUEBA", "PRUEBA", null, null));
        contactoList.add(new Contacto("PRUEBA2", "PRUEBA2", null, "PRUEBA2", "PRUEBA2", null, null));

        return contactoList;
    }
}
