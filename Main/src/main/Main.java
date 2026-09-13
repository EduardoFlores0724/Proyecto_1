/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {
        Scanner TK = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("   SISTEMA INTEGRADO DE GESTIÓN - PROYECTO   ");
        System.out.println("=============================================\n");

        // 1. Ejecutar el control de acceso (Login)
        System.out.println("--> PASO 1: Autenticación de Usuario");
        boolean loginExitoso = Servicio_Autentificacion.ejecutarLogin(TK);

        // 2. Si el login fue correcto, se procede a la verificación del Token
        if (loginExitoso) {
            System.out.println("\n--> PASO 2: Validación de Seguridad");
            boolean tokenValido = Servicio_Autentificacion.verificarTokenSeguridad(TK);

            if (tokenValido) {
                System.out.println("\n=============================================");
                System.out.println(" ¡ACCESO CONCEDIDO AL SISTEMA PRINCIPAL! ");
                System.out.println("=============================================");
                
                // Aquí se desplegará el menú principal cuando unamos los 3 escenarios
                desplegarMenuSimulado();
            } else {
                System.out.println("\n[ERROR DE SEGURIDAD] Token inválido. Sesión finalizada.");
            }

        } else {
            System.out.println("\n[ACCESO DENEGADO] No fue posible iniciar sesión.");
        }

        TK.close();
    }//fin de main

    // Método temporal para simular el menú general del proyecto
    public static void desplegarMenuSimulado() {
        System.out.println("\n--- Menú de Módulos (En Desarrollo) ---");
        System.out.println("1. Escenario 1: Control de Inventario y Ventas");
        System.out.println("2. Escenario 2: Gestión Académica y Promedios");
        System.out.println("3. Escenario 3: Seguridad y Autenticación (Completado)");
        System.out.println("4. Salir");
    }// fin de desplegarMenuSimulado
}//fin de class