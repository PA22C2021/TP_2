package com.example.tp_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.Enum.TipoTelefono;
import com.example.tp_2.databinding.ActivityMainBinding;

public class DetalleContacto extends BaseActivity{
    private ActivityMainBinding binding;

    Contacto contacto;

    Spinner spTipoTelefono;
    EditText etNombre, etApellido, etTelefono, etEmail, etFechaNacimiento, etDireccion;

    RadioGroup rgEstudios;
    RadioButton rbPrimarioIncompleto, rbPrimarioCompleto, rbSecundarioIncompleto, rbSecundarioCompleto, rbOtros;
    CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    Switch switchRecibirInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Detalles");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_detalle_contacto);

        Intent intent = getIntent();
        contacto = (Contacto) intent.getSerializableExtra("contacto");

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        etDireccion = (EditText) findViewById(R.id.etDireccion);

        spTipoTelefono = (Spinner) findViewById(R.id.spTipoTelefono);
        spTipoTelefono.setAdapter(new ArrayAdapter<TipoTelefono>(this, R.layout.support_simple_spinner_dropdown_item, TipoTelefono.values()));

        rgEstudios = (RadioGroup) findViewById(R.id.rgEstudios);
        rbPrimarioIncompleto = (RadioButton) findViewById(R.id.rbPrimarioIncompleto);
        rbPrimarioCompleto = (RadioButton) findViewById(R.id.rbPrimarioCompleto);
        rbSecundarioIncompleto = (RadioButton) findViewById(R.id.rbSecundarioInCompleto);
        rbSecundarioCompleto = (RadioButton) findViewById(R.id.rbSecundarioCompleto);
        rbOtros = (RadioButton) findViewById(R.id.rbOtros);

        cbDeporte = (CheckBox) findViewById(R.id.cbDeporte);
        cbMusica = (CheckBox) findViewById(R.id.cbMusica);
        cbArte = (CheckBox) findViewById(R.id.cbArte);
        cbTecnologia = (CheckBox) findViewById(R.id.cbTecnologia);

        switchRecibirInfo = (Switch) findViewById(R.id.swtichInfoSi);
    }
}
