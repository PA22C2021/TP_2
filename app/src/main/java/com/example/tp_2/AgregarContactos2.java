package com.example.tp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.Class.DatosAdicionales;
import com.example.tp_2.Enum.NivelEstudio;
import com.example.tp_2.databinding.ActivityMainBinding;

public class AgregarContactos2 extends AppCompatActivity {

    private ActivityMainBinding binding;

    Contacto contacto;

    RadioButton rbPrimarioIncompleto, rbPrimarioCompleto, rbSecundarioIncompleto, rbSecundarioCompleto, rbOtros;
    CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    Switch switchRecibirInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_agregar_contactos_2);

        Intent intent = getIntent();
        contacto = (Contacto) intent.getSerializableExtra("contacto");

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

    public void GuardarClick(View view)
    {
        DatosAdicionales datosAdicionales = new DatosAdicionales();

        // Seteo nivel de estudio
        if (rbPrimarioIncompleto.isChecked())
        {
            datosAdicionales.setNivelEstudio(NivelEstudio.PrimarioIncompleto);
        }
        else if (rbPrimarioCompleto.isChecked())
        {
            datosAdicionales.setNivelEstudio(NivelEstudio.PrimarioCompleto);
        }
        else if (rbSecundarioIncompleto.isChecked())
        {
            datosAdicionales.setNivelEstudio(NivelEstudio.SecundarioIncompleto);
        }
        else if (rbSecundarioCompleto.isChecked())
        {
            datosAdicionales.setNivelEstudio(NivelEstudio.SecundarioCompleto);
        }
        else if (rbOtros.isChecked())
        {
            datosAdicionales.setNivelEstudio(NivelEstudio.Otros);
        }

        // Seteo de intereses

        if (cbDeporte.isChecked())
        {
            datosAdicionales.setInteresDeporte(true);
        }

        if (cbMusica.isChecked())
        {
            datosAdicionales.setInteresMusica(true);
        }

        if (cbArte.isChecked())
        {
            datosAdicionales.setInteresArte(true);
        }

        if (cbTecnologia.isChecked())
        {
            datosAdicionales.setInteresTecnología(true);
        }
        
        // Seteo recibir informacion
        if (switchRecibirInfo.isChecked())
        {
            datosAdicionales.setRecibirInformacion(true);
        }

        contacto.setDatosAdicionales(datosAdicionales);
        
        Intent intent = new Intent(view.getContext(), ListadoContactos.class);
        intent.putExtra("contactocompleto", contacto);
        startActivity(intent);
        this.finish();
    }
}