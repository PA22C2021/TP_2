package com.example.tp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.Class.DatosAdicionales;
import com.example.tp_2.Class.Telefono;
import com.example.tp_2.Enum.TipoTelefono;

import java.util.List;

public class AgregarContactos extends BaseActivity {

    private com.example.tp_2.databinding.ActivityMainBinding binding;

    Spinner spTipoTelefono;
    EditText etNombre, etApellido, etTelefono, etEmail, etFechaNacimiento, etDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title);
        binding = com.example.tp_2.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_agregar_contactos);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        etDireccion = (EditText) findViewById(R.id.etDireccion);

        spTipoTelefono = (Spinner) findViewById(R.id.spTipoTelefono);
        spTipoTelefono.setAdapter(new ArrayAdapter<TipoTelefono>(this, R.layout.support_simple_spinner_dropdown_item, TipoTelefono.values()));
    }

    public void AceptarClick(View view)
    {
        // TODO: Faltan validaciones de los controles.


        // Cargo el contacto.
        Contacto nuevoContacto = new Contacto(etNombre.getText().toString(), etApellido.getText().toString(),
                new Telefono(etTelefono.getText().toString(), (TipoTelefono) spTipoTelefono.getSelectedItem()),
                etEmail.getText().toString(), etDireccion.getText().toString(), etFechaNacimiento.getText().toString(), null);

        Intent intent = new Intent(view.getContext(), AgregarContactos2.class);
        intent.putExtra("contacto", nuevoContacto);
        startActivity(intent);
        this.finish();
    }
}