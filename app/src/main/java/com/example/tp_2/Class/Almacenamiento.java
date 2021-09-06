package com.example.tp_2.Class;

import android.app.Activity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.OutputStreamWriter;

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

    public static boolean ArchivoExiste(String archivos [], String NombreArchivo){
        for(int i = 0; i < archivos.length; i++)
            if(NombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }
}
