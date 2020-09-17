package com.uco.mantenimientoelectrodomesticos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uco.mantenimientoelectrodomesticos.utilidades.Validar;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class RegistroFormularioActivity extends AppCompatActivity {

    private Button guardar;
    public Propietario propietario;
    private List<Propietario> listadoPropietarios = new ArrayList<>();
    boolean bandera = false;

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

        /*guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarse();
            }
        });*/


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarse();
            }
        });

    }

    /*
    private void guardarDatos() {
        bandera = false;
        String idPropietario = Validar.quitarEspacios(identificacion.getText().toString());
        String nombrePropietario = Validar.unSoloEspacio(nombre.getText().toString());
        String correoPropietario = correo.getText().toString();
        String direccionPropietario = Validar.unSoloEspacio(direccion.getText().toString());
        String telefonoPropietario = telefono.getText().toString();

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
    }*/





    // intente de jecutar ese metodo para guardar datos para ver como funciona
    private void registrarse(){
        if (!(Validar.idProprietario(identificacion.getText().toString(),listadoPropietarios))){
            String mensaje = Validar.registroProprietario(identificacion.getText().toString(),nombre.getText().toString(),
                    correo.getText().toString(),direccion.getText().toString(),telefono.getText().toString(),listadoPropietarios);

            if (mensaje.equals("EXITO!!!")){

                Propietario propietario = new Propietario(identificacion.getText().toString(),nombre.getText().toString(),
                        correo.getText().toString(),direccion.getText().toString(),telefono.getText().toString());

                listadoPropietarios.add(propietario);

                Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
                //Borrar los datos despues de un proceso con exito
                identificacion.getText().clear();
                nombre.getText().clear();
                correo.getText().clear();
                direccion.getText().clear();
                telefono.getText().clear();

            }else {
                Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Ya existe una persona con esta identificación",Toast.LENGTH_SHORT).show();
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