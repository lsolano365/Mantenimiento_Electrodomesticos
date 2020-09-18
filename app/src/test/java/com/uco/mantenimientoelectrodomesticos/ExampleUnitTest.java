package com.uco.mantenimientoelectrodomesticos;

import com.uco.mantenimientoelectrodomesticos.modelo.Propietario;
import com.uco.mantenimientoelectrodomesticos.utilidades.Validar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@SuppressWarnings("ALL")
public class ExampleUnitTest {
    private List<Propietario> listadoPropietarios=new ArrayList<>();
    private Propietario propietario;


    @Test
    public void guardarDatos() {


        String idPropietario = "1036962400";
        String nombrePropietario = "Luis Eduardo";
        String correoPropietario = "luis@gmail.com";
        String direccionPropietario = "marinilla";
        String telefonoPropietario = "3116856400";

        // verifique si podemos crear ese objeto con esos datos
        String mensajeDeValidacion = Validar.registroProprietario(idPropietario,nombrePropietario,correoPropietario,direccionPropietario,telefonoPropietario,listadoPropietarios);

        assertEquals("EXITO!!!",mensajeDeValidacion);
    }


    @Test
    public void unSoloEspacio() {
        String cadena = "      JOE        WATSON    ";
        assertEquals("JOE WATSON", Validar.unSoloEspacio(cadena));
    }

    @Test
    public void idIsExiste(){

        listadoPropietarios.add(new Propietario("98686","Santiago","santiago@gmail.com","cl 51","3049852637",""));
        listadoPropietarios.add(new Propietario("24352345","Luis","luis@gmail.com","cl 65","8765867856",""));
        listadoPropietarios.add(new Propietario("66763745","Joe Watson SBF","joe@gmail.com","cl 51","3049852637",""));

        boolean validar= Validar.idProprietario("66763745",listadoPropietarios);

        assertTrue(validar);

    }


    @Test
    public void quitarLosEspacios(){
        String texto= Validar.quitarEspacios("7673 43675 34573 668            345345");
        assertEquals("76734367534573668345345",texto);
    }

    @Test
    public void verifacarEmail(){
        String email="watsonjoe40@gmail.com";
        assertEquals("watsonjoe40@gmail.com",Validar.email(email));
    }


}