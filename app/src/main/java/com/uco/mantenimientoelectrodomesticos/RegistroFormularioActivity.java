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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroFormularioActivity extends AppCompatActivity {

    private Button guardar;
    public Propietario propietario;
    DatabaseReference mDatabase;
    private List<Propietario> listadoPropietarios;

    private EditText nombre, correo, identificacion, direccion, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_formulario);

        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();

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

        listadoPropietarios = new ArrayList<>();

        String idPropietario = identificacion.getText().toString().trim();
        String nombrePropietario = nombre.getText().toString();
        String correoPropietario = correo.getText().toString().trim();
        String direccionPropietario = direccion.getText().toString();
        String telefonoPropietario = telefono.getText().toString();

        propietario = new Propietario(idPropietario, nombrePropietario, correoPropietario, direccionPropietario, telefonoPropietario);

        Map<String, Object> map = new HashMap<>();
        map.put("nombre", nombrePropietario);
        map.put("idP", idPropietario);
        map.put("correo", correoPropietario);
        map.put("telefono", telefonoPropietario);
        map.put("direccion", direccionPropietario);


        mDatabase.child("propietario").child(propietario.getIdPropietario()).setValue(map);
        mDatabase.child("propietario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Propietario propietariosDatabase = postSnapshot.getValue(Propietario.class);
                    listadoPropietarios.add(propietariosDatabase);
                }
                Toast.makeText(getBaseContext(), "listado: " + listadoPropietarios, Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Se ha registrado con exito! " + propietario.getNombre(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}