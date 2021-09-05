package com.example.tp_2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.Class.DatosAdicionales;
import com.example.tp_2.Class.Telefono;
import com.example.tp_2.Enum.TipoTelefono;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(formularioEsValido())
        {
            Contacto nuevoContacto = new Contacto(etNombre.getText().toString(), etApellido.getText().toString(),
                    new Telefono(etTelefono.getText().toString(), (TipoTelefono) spTipoTelefono.getSelectedItem()),
                    etEmail.getText().toString(), etDireccion.getText().toString(), etFechaNacimiento.getText().toString(), null);

            Intent intent = new Intent(view.getContext(), AgregarContactos2.class);
            intent.putExtra("contacto", nuevoContacto);
            startActivity(intent);
            this.finish();
        }
    }

    public boolean formularioEsValido() {
        return nombreEsValido() &&
                apellidoEsValido() &&
                telefonoEsValido() &&
                emailEsValido() &&
                fechaNacimientoEsValida() &&
                direccionEsValido();
    }

    public boolean nombreEsValido() {
        final String nombre = etNombre.getText().toString();

        if(nombre.length() == 0) {
            etNombre.requestFocus();
            etNombre.setError("Campo requerido");
            return false;
        }
        return true;
    }

    public boolean apellidoEsValido() {
        final String apellido = etApellido.getText().toString();

        if(apellido.length() == 0) {
            etApellido.requestFocus();
            etApellido.setError("Campo requerido");
            return false;
        }
        return true;
    }


    public boolean telefonoEsValido() {
        final String telefono = etTelefono.getText().toString();

        if(telefono.length() == 0) {
            etTelefono.requestFocus();
            etTelefono.setError("Campo requerido");
            return false;
        }
        return true;
    }


    public boolean emailEsValido() {
        final String email = etEmail.getText().toString();
        final String regex = "^(.+)@(.+)$";

        if(etEmail.length() == 0) {
            etEmail.requestFocus();
            etEmail.setError("Campo requerido");
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            etEmail.requestFocus();
            etEmail.setError("Formato no válido");
            return false;
        }

        return true;
    }

    public boolean fechaNacimientoEsValida() {
        final String fechaNacimiento = etFechaNacimiento.getText().toString();

        if(fechaNacimiento.length() == 0) {
            etFechaNacimiento.requestFocus();
            etFechaNacimiento.setError("Campo requerido");
            return false;
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                LocalDate.parse(fechaNacimiento, formatter);
            } catch (Exception e) {
                etFechaNacimiento.requestFocus();
                etFechaNacimiento.setError("Formato no válido");
                return false;
            }
        }
        return true;
    }

    public boolean direccionEsValido() {
        final String direccion = etDireccion.getText().toString();

        if(direccion.length() == 0) {
            etDireccion.requestFocus();
            etDireccion.setError("Campo requerido");
            return false;
        }
        return true;
    }

}