package com.uco.mantenimientoelectrodomesticos.ui.registros_mantenimiento;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;


import com.uco.mantenimientoelectrodomesticos.R;
import com.uco.mantenimientoelectrodomesticos.RegistroFormularioActivity;

public class RegistrosMantenimientoFragment extends Fragment {


    private Button ingresar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrosmantenimiento, container, false);

        ingresar = view.findViewById(R.id.btnIngresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegistroFormularioActivity.class));
            }
        });



        return view;

    }



}