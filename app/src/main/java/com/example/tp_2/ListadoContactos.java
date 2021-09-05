package com.example.tp_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.databinding.ActivityMainBinding;

public class ListadoContactos extends BaseActivity {

    Contacto contacto;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title_contacts);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_listado_contactos);

        Intent intent = getIntent();
        contacto = (Contacto) intent.getSerializableExtra("contactocompleto");
    }
}