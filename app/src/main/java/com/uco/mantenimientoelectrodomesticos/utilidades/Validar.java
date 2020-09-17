package com.uco.mantenimientoelectrodomesticos.utilidades;

import com.uco.mantenimientoelectrodomesticos.Propietario;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
public class Validar {
    private static final String VACIO=" ";

    public static String unSoloEspacio(String cadena){
        String regex = "\\s{2,}";
        Pattern patron = Pattern.compile(regex,Pattern.MULTILINE);
        Matcher validador = patron.matcher(cadena);

        return validador.replaceAll(" ").trim();
    }

    public static String quitarEspacios(String cadena){
        String regex = "\\s+";
        Pattern patron = Pattern.compile(regex,Pattern.MULTILINE);
        Matcher validador = patron.matcher(cadena);
        return validador.replaceAll("").trim();
    }

    public static String email(String email) {
        email=quitarEspacios(email);
        return (email.contains(".") && email.contains("@")) ? email : VACIO;
    }


    public static boolean idProprietario(String identification, List<Propietario> lista){
        identification=quitarEspacios(identification);
        boolean encontrado=false;
        if (!lista.isEmpty()){
            for (Propietario propietario:lista) {
                if (propietario.getIdPropietario().equals(identification)){
                    encontrado=true;
                    break;
                }
            }
        }
        return encontrado;
    }

    public static String registroProprietario(String idPropietario, String nombre, String correo, String direccion, String telefono, List<Propietario> lista){

        String mensage="EXITO!!!";
        if (unSoloEspacio(direccion).isEmpty()) {
            mensage = "Rellene el campo de la direccion favor!";
        }
        if (quitarEspacios(telefono).isEmpty()){
            mensage="Ingrese un numero de telefono por favor!";
        }
        if (email(correo).equals(VACIO)){
            mensage="Se ocurre un error, ingrese un correo valido!\nPor ejemplo: mantenimiento@empresa.com";
        }

        if (quitarEspacios(idPropietario).isEmpty()){
            mensage="El numero de identificación no puede ser vacio";
        }
        if(unSoloEspacio(nombre).isEmpty()){
            mensage="Rellene el campo del nombre por favor!";
        }
        return mensage;
    }

    private static boolean estaVacia(String cadena){
        return cadena.isEmpty() ? true:false;
    }

}
