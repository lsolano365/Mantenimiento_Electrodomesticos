package com.uco.mantenimientoelectrodomesticos.validaciones;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigurarTexto {
    private static Context context;

    public static String validarEspacios(String cadena) {
        String resultado = "";
        if(cadena.isEmpty())
        {
            Toast.makeText(context, "Se encontró un campo vacío", Toast.LENGTH_SHORT).show();
        }else
        {
            final String ESPACIO = " ";
            String regex = "\\s{2,}";
            Pattern patron = Pattern.compile(regex,Pattern.MULTILINE);
            Matcher validador = patron.matcher(cadena);
            resultado = validador.replaceAll(ESPACIO).trim();

        }
        return resultado;
    }

    private static boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


}
