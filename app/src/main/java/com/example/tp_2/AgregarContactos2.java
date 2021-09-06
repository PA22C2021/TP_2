package com.example.tp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tp_2.Class.Almacenamiento;
import com.example.tp_2.Class.Contacto;
import com.example.tp_2.Class.DatosAdicionales;
import com.example.tp_2.Enum.NivelEstudio;
import com.example.tp_2.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AgregarContactos2 extends BaseActivity {

    private ActivityMainBinding binding;

    Contacto contacto;

    RadioGroup rgEstudios;
    RadioButton rbPrimarioIncompleto, rbPrimarioCompleto, rbSecundarioIncompleto, rbSecundarioCompleto, rbOtros;
    CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    Switch switchRecibirInfo;
    private final static String FileName = "contactos.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.title);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_agregar_contactos_2);

        Intent intent = getIntent();
        contacto = (Contacto) intent.getSerializableExtra("contacto");

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

    public void GuardarClick(View view)
    {
        if(!formularioEsValido()) return;

        // Si no hay ningun problema seteamos.
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

        Almacenamiento almacenamiento = new Almacenamiento();
        String archivos [] = fileList();
        /*if(!almacenamiento.ArchivoExiste(archivos, FileName)){
            try {
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(FileName, Activity.MODE_PRIVATE));
                archivo.write(contacto.getHeaderCSV());
                archivo.flush();
                archivo.close();
            }catch (IOException e){

            }
        }*/

        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(FileName, Activity.MODE_PRIVATE));
            archivo.write(contacto.toCSV());
            archivo.flush();
            archivo.close();
            Toast.makeText(this, "contacto guardado correctamente", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this, "contacto no se pudo guardar correctamente", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(view.getContext(), ListadoContactos.class);
        startActivity(intent);
        this.finish();
    }

    private boolean formularioEsValido() {
        return estudiosEsValido();
    }

    private boolean estudiosEsValido() {
        if(rgEstudios.getCheckedRadioButtonId() == -1) {
            rgEstudios.requestFocus();
            rbOtros.setError("");
            return false;
        }
        return true;
    }
}