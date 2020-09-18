package com.uco.mantenimientoelectrodomesticos.vista.ui.registros_mantenimiento;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uco.mantenimientoelectrodomesticos.R;

public class RegistrosElectrodomesticosFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_mantenimiento, container, false);


        return view;

    }



}