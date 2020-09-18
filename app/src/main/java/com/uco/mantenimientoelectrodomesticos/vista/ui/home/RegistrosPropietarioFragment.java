package com.uco.mantenimientoelectrodomesticos.vista.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;


import com.uco.mantenimientoelectrodomesticos.R;
import com.uco.mantenimientoelectrodomesticos.modelo.Electrodomestico;
import com.uco.mantenimientoelectrodomesticos.modelo.Propietario;
import com.uco.mantenimientoelectrodomesticos.utilidades.Adaptador;
import com.uco.mantenimientoelectrodomesticos.utilidades.Validar;
import com.uco.mantenimientoelectrodomesticos.vista.MainActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RegistrosPropietarioFragment extends Fragment {

    //private Adaptador adaptador;

    private ListView list;
    Adaptador myAdapter;
    private Button guardar;
    public static List<Propietario> listadoPropietarios = new ArrayList<>();
    private Date objDate = new Date();

    private EditText nombre, correo, identificacion, direccion, telefono;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_propietarios, container, false);

        guardar = (Button) view.findViewById(R.id.btnGuardar);

        nombre = (EditText) view.findViewById(R.id.edtNombreP);
        correo = (EditText) view.findViewById(R.id.edtCorreo);
        identificacion = (EditText) view.findViewById(R.id.edtIdentificacion);
        direccion = (EditText) view.findViewById(R.id.edtDireccion);
        telefono = (EditText) view.findViewById(R.id.edtTelefono);

        list = (ListView) view.findViewById(R.id.listViewProp);

        listadoPropietarios.add(new Propietario("123", "luis", "luis@gmail.com", "dsadasdasd", "3116856400", ""));

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarse();
            }
        });

        list.setAdapter(new Adaptador(listadoPropietarios, getContext()));

        return view;
    }

    private void registrarse(){


        String fecha = objDate.toString();

        if (!(Validar.idProprietario(identificacion.getText().toString()))){
            String mensaje = Validar.registroProprietario(identificacion.getText().toString(),nombre.getText().toString(),
                    correo.getText().toString(),direccion.getText().toString(),telefono.getText().toString());

            if (mensaje.equals("SE HA REGISTRADO CORRECTAMENTE!!!")){

                Propietario propietario = new Propietario(identificacion.getText().toString(),nombre.getText().toString(),
                        correo.getText().toString(),direccion.getText().toString(),telefono.getText().toString(), fecha);

                listadoPropietarios.add(propietario);
                myAdapter = new Adaptador(listadoPropietarios, getContext());
                Toast.makeText(getContext(),mensaje,Toast.LENGTH_LONG).show();
                //Borrar los datos despues de un proceso con exito
                identificacion.getText().clear();
                nombre.getText().clear();
                correo.getText().clear();
                direccion.getText().clear();
                telefono.getText().clear();

            }else {
                Toast.makeText(getContext(),mensaje,Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getContext(), "Ya existe una persona con esta identificación",Toast.LENGTH_SHORT).show();
        }

    }
}