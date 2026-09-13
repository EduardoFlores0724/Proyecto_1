/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Servicio_Autentificacion{

    // Método para validar credenciales según el estilo habitual
    public static boolean validarUsuario(String usuario, String contrasena) {
        return usuario.equalsIgnoreCase("admin") && contrasena.equals("12345");
    }

    // Método de generación de Token alineado al ejercicio Generacionde_token.java
    public static String generarTokenClase() {
        Random RD = new Random();
        String token = "";
        int tipoCaracter;
        int numerotoken;
        char letratoken;

        // Bucle que genera un token de 12 caracteres (números y letras ASCII)
        while (token.length() < 12) {
            tipoCaracter = RD.nextInt(2); // 0 para número, 1 para letra

            if (tipoCaracter == 0) {
                numerotoken = RD.nextInt(10);
                token = token + numerotoken;
            } else {
                // Generación de letra mayúscula usando código ASCII (65 al 90)
                letratoken = (char) (RD.nextInt(26) + 65);
                token = token + letratoken;
            }
        }
        return token;
    }

    // Método para solicitar y verificar el token
    public static boolean verificarTokenSeguridad(Scanner TK) {
        String tokenGenerado = generarTokenClase();
        
        System.out.println("\n=== VALIDACIÓN DE TOKEN ===");
        System.out.printf("token: %s\n", tokenGenerado);

        System.out.print("Ingrese el token generado para validar: ");
        String tokenIngresado = TK.nextLine();

        if (tokenIngresado.equals(tokenGenerado)) {
            System.out.println("Registro correcto");
            return true;
        } else {
            System.out.println("Token incorrecto. Acceso denegado.");
            return false;
        }
    }

    // Proceso completo de inicio de sesión con control de intentos
    public static boolean ejecutarLogin(Scanner TK) {
        int intentos = 0;
        boolean isValido = false;

        do {
            System.out.print("Ingrese usuario: ");
            String user = TK.nextLine();

            System.out.print("Ingrese contraseña: ");
            String pass = TK.nextLine();

            isValido = validarUsuario(user, pass);

            if (!isValido) {
                intentos++;
                System.out.println("Credenciales incorrectas. Intentos: " + intentos + "/3");
            }

        } while (!isValido && intentos < 3);

        return isValido;
    }
}

