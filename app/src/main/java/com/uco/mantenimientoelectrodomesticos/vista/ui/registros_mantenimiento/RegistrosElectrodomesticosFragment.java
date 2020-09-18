package com.uco.mantenimientoelectrodomesticos.vista.ui.registros_mantenimiento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;


import com.uco.mantenimientoelectrodomesticos.R;
import com.uco.mantenimientoelectrodomesticos.modelo.Electrodomestico;
import com.uco.mantenimientoelectrodomesticos.modelo.Propietario;
import com.uco.mantenimientoelectrodomesticos.utilidades.Adaptador;
import com.uco.mantenimientoelectrodomesticos.utilidades.Validar;
import com.uco.mantenimientoelectrodomesticos.vista.ui.home.RegistrosPropietarioFragment;

import java.util.ArrayList;
import java.util.Date;

public class RegistrosElectrodomesticosFragment extends Fragment {


    private EditText nombreElectrodomestico, idProprietarioElect, marca, serial, descripción, observacionTecnica;

    private Button guardarElectrodomestico;

    public static ArrayList<Electrodomestico> listadoElectrodomesticos = new ArrayList<>();

    private Date objDate = new Date();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_mantenimiento, container, false);

        nombreElectrodomestico = (EditText) view.findViewById(R.id.edtNombreElect);
        idProprietarioElect=(EditText) view.findViewById(R.id.edtIdProprietarioElect);
        marca = (EditText) view.findViewById(R.id.edtMarca);
        serial = (EditText) view.findViewById(R.id.edtSerial);
        descripción = (EditText) view.findViewById(R.id.edtDiagnostico);
        observacionTecnica = (EditText) view.findViewById(R.id.edtObsTecn);

        guardarElectrodomestico = (Button) view.findViewById(R.id.btnGuardarElect);

        guardarElectrodomestico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarElectrodomestico();
            }
        });

        return view;

    }




    public void RegistrarElectrodomestico() {

        String fecha = objDate.toString();

        String idPropietario = Validar.obtenerIDproprietario(idProprietarioElect.getText().toString());

        if (!idPropietario.isEmpty()){
            String mensaje = Validar.registroElectrodomestico(nombreElectrodomestico.getText().toString(),marca.getText().toString(),
                    serial.getText().toString());

            boolean serialExist=Validar.serialElectrodomestico(serial.getText().toString());

            if(!serialExist){
                if (mensaje.equals("Se ha añadido el electrodomestico correctamente!")){

                    Electrodomestico electrodomestico = new Electrodomestico(nombreElectrodomestico.getText().toString(), marca.getText().toString(), idPropietario, serial.getText().toString(),
                            descripción.getText().toString(), observacionTecnica.getText().toString(),true, fecha);

                    listadoElectrodomesticos.add(electrodomestico);
                    //añadir adaptador
                    Toast.makeText(getContext(),mensaje,Toast.LENGTH_LONG).show();
                    //Borrar los datos despues de un proceso con exito
                    nombreElectrodomestico.getText().clear();
                    marca.getText().clear();
                    serial.getText().clear();
                    descripción.getText().clear();
                    observacionTecnica.getText().clear();

                }else {
                    Toast.makeText(getContext(),mensaje,Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(getContext(), "No puede registarlo con un serial que ya existe!" ,Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getContext(), "El campo identification del proprietario no puede ser vacio!" ,Toast.LENGTH_SHORT).show();
        }
    }
}