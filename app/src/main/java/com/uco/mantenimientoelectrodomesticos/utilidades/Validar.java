package com.uco.mantenimientoelectrodomesticos.utilidades;

import com.uco.mantenimientoelectrodomesticos.modelo.Propietario;
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

        String mensage="SE HA REGISTRADO CORRECTAMENTE!!!";
        if (unSoloEspacio(direccion).isEmpty()) {
            mensage = "Por favor rellene el campo dirección!";
        }
        if (quitarEspacios(telefono).isEmpty()){
            mensage="Por favor ingrese un número de telefono válido!";
        }
        if (email(correo).equals(VACIO)){
            mensage="Se ocurre un error, ingrese un correo valido!\nPor ejemplo: mantenimiento@empresa.com";
        }

        if (quitarEspacios(idPropietario).isEmpty()){
            mensage="El numero de identificación no puede ser vacio";
        }
        if(unSoloEspacio(nombre).isEmpty()){
            mensage="Por favor rellene el campo nombre!";
        }
        return mensage;
    }

    public static String registroElectrodomestico(String nombreElectrodomestico, String marca, String serial){
        String mensaje = "Se ha añadido el electrodomestico correctamente!";

        if (unSoloEspacio(nombreElectrodomestico).isEmpty()){
            mensaje = "Por favor rellene el campo nombre electrodoméstico";
        }
        if (unSoloEspacio(marca).isEmpty()){
            mensaje = "por favor rellene el campo marca";
        }
        if (quitarEspacios(serial).isEmpty()){
            mensaje = "Por favor rellene el campo serial";
        }

        return mensaje;
    }

    private static boolean estaVacia(String cadena){
        return cadena.isEmpty() ? true:false;
    }

}
