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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private List<Propietario> listadoPropietarios;
    private Propietario propietario;



    @Test
    public void guardarDatos() {

        listadoPropietarios = new ArrayList<>();

        String idPropietario = "1036962400";
        String nombrePropietario = "Luis Eduardo";
        String correoPropietario = null;
        String direccionPropietario = "marinilla";
        String telefonoPropietario = "3116856400";

        propietario = new Propietario(idPropietario, nombrePropietario, correoPropietario, direccionPropietario, telefonoPropietario);

    }
    @Test
    public void validarTexto() {
        final String ESPACIO = " ";
        String cadena = "JOE        WATZSON    ";
        String regex = "\\s{2,}";
        Pattern patron = Pattern.compile(regex,Pattern.MULTILINE);
        Matcher validador = patron.matcher(cadena);
        String resultado = validador.replaceAll(ESPACIO).trim();
        assertEquals("JOE WATZSON", resultado);
    }


}