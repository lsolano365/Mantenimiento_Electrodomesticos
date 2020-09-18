package com.uco.mantenimientoelectrodomesticos;

import com.uco.mantenimientoelectrodomesticos.modelo.Electrodomestico;
import com.uco.mantenimientoelectrodomesticos.modelo.Propietario;
import com.uco.mantenimientoelectrodomesticos.utilidades.Validar;
import com.uco.mantenimientoelectrodomesticos.vista.ui.home.RegistrosPropietarioFragment;
import com.uco.mantenimientoelectrodomesticos.vista.ui.registros_mantenimiento.RegistrosElectrodomesticosFragment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
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
    private Propietario propietario;
    private Electrodomestico electrodomestico;


    @Test
    public void guardarDatosProprietario() {

        String idPropietario = "1036962400";
        String nombrePropietario = "Luis Eduardo";
        String correoPropietario = "luis@gmail.com";
        String direccionPropietario = "marinilla";
        String telefonoPropietario = "3116856400 ";

        // verifique si podemos crear ese objeto con esos datos
        String mensajeDeValidacion = Validar.registroProprietario(idPropietario,nombrePropietario,correoPropietario,direccionPropietario,telefonoPropietario);

        assertEquals("SE HA REGISTRADO CORRECTAMENTE!!!",mensajeDeValidacion);
    }

    @Test
    public void guardarDatosElectrodomestico() {

        String nombreElectrodomestico="Lavadora", marcaElectrodomestico="Cualquiera", serial="567GFD7";

        // verifique si podemos crear ese objeto con esos datos
        String mensajeDeValidacion = Validar.registroElectrodomestico(nombreElectrodomestico,marcaElectrodomestico, serial);
        assertEquals("Se ha añadido el electrodomestico correctamente!",mensajeDeValidacion);

    }


    @Test
    public void unSoloEspacio() {
        String cadena = "      JOE        WATSON    ";
        assertEquals("JOE WATSON", Validar.unSoloEspacio(cadena));
    }

    @Test
    public void idIsExiste(){

        RegistrosPropietarioFragment.listadoPropietarios.add(new Propietario("98686","Santiago","santiago@gmail.com","cl 51","3049852637",""));
        RegistrosPropietarioFragment.listadoPropietarios.add(new Propietario("24352345","Luis","luis@gmail.com","cl 65","8765867856",""));
        RegistrosPropietarioFragment.listadoPropietarios.add(new Propietario("66763745","Joe Watson SBF","joe@gmail.com","cl 51","3049852637",""));

        boolean validar= Validar.idProprietario("66763745");
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

    @Test
    public void VerificaSiExisteProprietario(){
        // antes de aceptar a guardar un electrodomestico, tenemos que garantizar que el proprietario ya registrado en el sistema con el ID ingresado

        RegistrosPropietarioFragment.listadoPropietarios.add(new Propietario("98686","Santiago","santiago@gmail.com","cl 51","3049852637",""));
        RegistrosPropietarioFragment.listadoPropietarios.add(new Propietario("24352345","Luis","luis@gmail.com","cl 65","8765867856",""));
        RegistrosPropietarioFragment.listadoPropietarios.add(new Propietario("66763745","Joe Watson SBF","joe@gmail.com","cl 51","3049852637",""));

        String id= "24352345";
        assertEquals(id, Validar.obtenerIDproprietario("24352345"));
    }

    @Test
    public void verifacacionSerialElectrodomestico(){

        RegistrosElectrodomesticosFragment.listadoElectrodomesticos.add(new Electrodomestico("Lavadora","SAMSUNG",
                "12345", "0987654321","bla bla bla", "la bla bla",true,"19/09/2020"));


        //boolean existe=Validar.serialElectrodomestico("0987654321"); // con este no lo va aceptar; el serial ya existe

        boolean existe=Validar.serialElectrodomestico("0123456789"); // con este si lo va aceptar


        String mensaje = "";
        mensaje= existe==true ? "Ya existe un elect con este SERIAL" : "EXITO!!!";

        assertEquals("EXITO!!!", mensaje);
    }

}