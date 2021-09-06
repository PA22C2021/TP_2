package com.example.tp_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tp_2.Class.Almacenamiento;
import com.example.tp_2.Class.Contacto;
import com.example.tp_2.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListadoContactos extends BaseActivity {
    ListView lvContactos;
    Contacto contacto;

    private ActivityMainBinding binding;
    private final static String FileName = "contactos.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title_contacts);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_listado_contactos);

        lvContactos = (ListView) findViewById(R.id.lvContacto);

        Almacenamiento almacenamiento = new Almacenamiento();
        String archivos [] = fileList();

        ArrayList<Contacto> contactoList = new ArrayList<Contacto>();

        if(almacenamiento.ArchivoExiste(archivos, FileName)){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(FileName));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();

                while(linea != null){
                    contactoList.add(contacto.fromCsvToClass(linea));
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
            }catch (IOException e){

            }
        }

        CargarContactos(contactoList);
    }

    private void CargarContactos(ArrayList<Contacto> contactoList)
    {
        // Recibe una lista de contactos y la setea en el listview.
        ArrayAdapter<Contacto> arrayAdapter = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactoList);
        lvContactos.setAdapter(arrayAdapter);
    }
}