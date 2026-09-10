/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asentamientomarciano;

import java.util.Scanner;

/**
 * //
 * * El año es 2045, Eres el Ingeniero en Jefe de Software de la colonia marciana
 * "Ares V". Una reciente tormenta de arena ha dañado los sistemas principales
 * y el comandante te ha encomendado escribir un programa de emergencia en Java 
 * para estabilizar la base. 
 * 
 * Tu misión se divide en dos fases críticas que determinarán la supervivencia
 * de la tripulación.
 * 
 * Fase 1: El Sistema de Energía
 * Los paneles solares principales están funcionando de manera irregular. 
 * Tienes que analizar la energía generada durante los últimos 7 días.
 * 
 * Tu tarea:
 * Crea un arreglo unidimensional que almacene la energía generada (en Megavatios)
 * durante los últimos 7 días. 
 * 
 * El sistema debe calcular y mostrar en pantalla:
 *  El total de energía generada en la semana.
 *  El promedio diario de energía.
 *  El día en el que se generó la menor cantidad de energía, 
 *      para emitir una alerta de revisión de ese panel.
 * 
 * Fase 2: El Invernadero Hidropónico
 * 
 * El suministro de comida depende del invernadero central, el 
 * cual está dividido en una cuadrícula (matriz) de 3x3 sectores. 
 * Los sensores han enviado las lecturas de humedad de cada sector, 
 * pero algunas tuberías se rompieron durante la tormenta.
 * 
 * Tu tarea:
 * Crear un arreglo bidimensional de 3x3 que represente los niveles de humedad 
 * (en porcentaje) de cada sector del invernadero. 

* El programa debe escanear toda la matriz y:
* Mostrar el mapa actual de humedad en formato de cuadrícula.
* Identificar qué sectores tienen un nivel de humedad crítico (menor al 50%) 
* y mostrar sus coordenadas para enviar a los drones de reparación automáticamente.
* 
* 
* 
 * @author SocFA
 */
public class AsentamientoMarciano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
    
    final int colu =3;
    final int fila = 3;  
    final int dias = 7;    
    int [] energiaAlmacenada = new int [dias];    
    int energiaTotal = 0;
    double PromedioEnergiaSemanal = 0;
    int menosEnergia = 0;
    
    int[] valoresEner = new int[dias];
  
    
    
    for(int i=0; i<dias; i++){
        System.out.printf("Ingresar energia %d\n",i+1);
        energiaAlmacenada[i] = ValidacionNumeroPositivo(scan);
    }//Fin de For
       energiaTotal = TotalEnergiaSemana(energiaAlmacenada);
       PromedioEnergiaSemanal = CalculoPromedioEnergia(energiaTotal, dias);
       menosEnergia = DiaMasBajoEnergia(energiaAlmacenada);
       
        System.out.println("--------------------------");
        System.out.println("--      Resultados      --");
        System.out.println("--------------------------");
        System.out.printf("Total Energia: %d\n",energiaTotal);
        System.out.printf("Promedio: %.2f<'n", PromedioEnergiaSemanal);
        System.out.printf("Menor Energia Registrada: %d\n", menosEnergia);
        
        System.out.println("\n--- FASE DOS ---");
        
        double[][] humedadSectorial = IngresamosMedicionesSensorHumedad(scan,fila, colu);
        
        
        
    }//Fin de main
    
      public static int ValidacionNumeroPositivo(Scanner sc){
          
          int numeroTemp = 0;
          
          do {
              System.out.println("Ingresa el dato de la lectura echa");
              System.out.print("Lectura:");
              numeroTemp = sc.nextInt();
          
              if (numeroTemp<0) {
                  System.out.println("Lectura Erronea");
                  System.out.println("No puede ser negativo");
                  System.out.println("Ingresarlo nuevamente");
                  System.out.println("\n");
              }
          
          }while (numeroTemp<0);
         
          return numeroTemp;
          
      }//Fin de Validacion Numero positivo
      
      public static int TotalEnergiaSemana(int[]arreglo){
          int energiaAcumulada = 0;
        
          for(int i = 0; i<arreglo.length; i++){
              energiaAcumulada += arreglo[i];
          }
          
          return energiaAcumulada;
      }//Fin TotalEnergiaSemana
      
      public static double CalculoPromedioEnergia(int sumaTotal, int numDias){
          double promedio = 0;
          promedio = sumaTotal / numDias;
          
          return promedio;
      }//Fin CalculoPromedioEnergia
      
      public static int DiaMasBajoEnergia(int[]arreglo){
          int energiaTemp = arreglo[0];
          int indice = 0;
          
          for(int i = 1; i <arreglo.length; i++){
              if(energiaTemp<arreglo[i]){
                  energiaTemp = arreglo[i];
                  indice = i;
              }
          }//Fin de For
          
          return indice;
      }
      public static double[][] IngresamosMedicionesSensorHumedad(Scanner sc, int fila, int colu){
        double[][] arregloTemp = new double [fila][colu];
          System.out.println("Ingresa datos de cada sector");
        for(int i = 0; i < fila; i++){
            for(int j = 0; j < colu; j++){
                arregloTemp[i][j] = sc.nextDouble();
            }

        }
        return arregloTemp;
          
      }//fin funcion IngresamosMedicionesSensorHumedad
      
      public static void mostrarMapaSectorial(double[][] arreglo){
          System.out.println("\n--------------------------");
          for (int i =0; i < arreglo.length; i++){
              for (int j = 0; j < arreglo[i].length; j++){
                  System.out.println("\t"+arreglo[i][j]);
              }
              System.out.println("\n-----------------------");
          }//fin ciclo
          
          
          
      }//fin de funcion mostrarMapaSectorial
      public static void SectoresCriticos(double[][] arreglo){
          for(int i=0; i< arreglo.length;i++){
              for(int j = 0; j < arreglo[i].length; j++){
                  if(arreglo[i][j]<50){
                      System.out.println("\nValor Critico");
                      System.out.printf("Sector %d,%d\n",i,j);
                     // System.out.println("Sector: %d,%d\n",i,);
                      System.out.printf("Valor: %.2f",arreglo[i][j]);
                      
                      
                  }
              }//fin Columna
          }//fin fila
          
      }//fin funcion SectoresCriticos
      
     
}//Fin de Class