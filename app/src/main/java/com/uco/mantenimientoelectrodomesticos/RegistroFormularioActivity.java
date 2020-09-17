package com.uco.mantenimientoelectrodomesticos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.uco.mantenimientoelectrodomesticos.validaciones.ConfigurarTexto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroFormularioActivity extends AppCompatActivity {

    private Button guardar;
    public Propietario propietario;
    private List<Propietario> listadoPropietarios = new ArrayList<>();
    boolean bandera;

    private EditText nombre, correo, identificacion, direccion, telefono;

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_formulario);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        guardar = (Button) findViewById(R.id.btnGuardar);

        nombre = (EditText) findViewById(R.id.edtNombreP);
        correo = (EditText) findViewById(R.id.edtCorreo);
        identificacion = (EditText) findViewById(R.id.edtIdentificacion);
        direccion = (EditText) findViewById(R.id.edtDireccion);
        telefono = (EditText) findViewById(R.id.edtTelefono);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
        bandera = false;
        String idPropietario = identificacion.getText().toString().trim();
        String nombrePropietario = ConfigurarTexto.validarEspacios(nombre.getText().toString());
        String correoPropietario = correo.getText().toString().trim();
        String direccionPropietario = ConfigurarTexto.validarEspacios(direccion.getText().toString());
        String telefonoPropietario = ConfigurarTexto.validarEspacios(telefono.getText().toString());

        if (!idPropietario.isEmpty() && !nombrePropietario.isEmpty() && !correoPropietario.isEmpty() && !direccionPropietario.isEmpty() && !telefonoPropietario.isEmpty()) {
            if (listadoPropietarios.size() == 0) {
                listadoPropietarios.add(new Propietario(idPropietario, nombrePropietario, correoPropietario, direccionPropietario, telefonoPropietario));
                Toast.makeText(this, "Se registró con exito", Toast.LENGTH_SHORT).show();
            } else {
                for (Propietario prop: listadoPropietarios) {
                    if(prop.getIdPropietario().equals(idPropietario)){
                        bandera = true;
                    }
                }
                if(bandera){
                    Toast.makeText(this, "Ya existe una persona con esta identificación",Toast.LENGTH_SHORT).show();
                }else{
                    listadoPropietarios.add(new Propietario(idPropietario, nombrePropietario, correoPropietario, direccionPropietario, telefonoPropietario));
                }
            }
        } else {
            Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}