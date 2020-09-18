package com.uco.mantenimientoelectrodomesticos.utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uco.mantenimientoelectrodomesticos.R;
import com.uco.mantenimientoelectrodomesticos.modelo.Propietario;

import java.util.List;

public class Adaptador extends BaseAdapter {

    List<Propietario> listaPropietariosAdapter;
    Context context;
    private static LayoutInflater inflater = null;

    public Adaptador(List<Propietario> listaPropietariosAdapter, Context context) {
        this.listaPropietariosAdapter = listaPropietariosAdapter;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
       return listaPropietariosAdapter.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPropietariosAdapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vista = view;
        if (vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.list_items_propietarios, null);
        }

        Propietario propietario = listaPropietariosAdapter.get(i);

        TextView nombre = (TextView) vista.findViewById(R.id.txtNombreProp);
        TextView identificacion = (TextView) vista.findViewById(R.id.txtIdentificacion);
        TextView correo = (TextView) vista.findViewById(R.id.txtCorreo);
        TextView telefono = (TextView) vista.findViewById(R.id.txtTelefono);
        TextView fechaInicio = (TextView) vista.findViewById(R.id.txtFechaInicio);

        nombre.setText(propietario.getNombre());
        identificacion.setText(propietario.getIdPropietario());
        correo.setText(propietario.getCorreo());
        telefono.setText(propietario.getTelefono());
        fechaInicio.setText(propietario.getFechaInicio());

        return vista;
    }
}
