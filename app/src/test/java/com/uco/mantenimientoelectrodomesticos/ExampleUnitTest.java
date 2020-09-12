package com.uco.mantenimientoelectrodomesticos;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private List<Propietario> listadoPropietarios;
    private Propietario propietario;
    DatabaseReference mDatabase;



    @Test
    public void guardarDatos() {

        mDatabase = FirebaseDatabase.getInstance().getReference();

        listadoPropietarios = new ArrayList<>();

        String idPropietario = "1036962400";
        String nombrePropietario = "Luis Eduardo";
        String correoPropietario = "luchito0841@gmail.com";
        String direccionPropietario = "marinilla";
        String telefonoPropietario = "3116856400";

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
                assertNotNull(propietario.getIdPropietario());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}