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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListadoContactos extends BaseActivity {
    ListView lvContactos;
    Contacto contacto;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title_contacts);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_listado_contactos);

        lvContactos = (ListView) findViewById(R.id.lvContacto);

        Almacenamiento almacenamiento = new Almacenamiento();
        CargarContactos(almacenamiento.Cargar());
    }

    private void CargarContactos(ArrayList<Contacto> contactoList)
    {
        // Recibe una lista de contactos y la setea en el listview.
        ArrayAdapter<Contacto> arrayAdapter = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactoList);
        lvContactos.setAdapter(arrayAdapter);
    }
}