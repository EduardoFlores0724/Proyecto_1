/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author HP
 */
public class ServicioInventario {

    // Arreglos paralelos para los productos, precios y stock
    public static String[] productos = {"Laptop Gamer", "Teléfono 5G", "Mouse Inalámbrico", "Teclado Mecánico", "Monitor 24 pulgadas"};
    public static double[] precios = {18500.00, 8500.00, 450.00, 1200.00, 3800.00};
    public static int[] stock = {10, 15, 25, 12, 8};

    // catálogo 
    public static void mostrarInventario() {
        System.out.println("\n=============================================");
        System.out.println("       CATÁLOGO DE PRODUCTOS DISPONIBLES     ");
        System.out.println("=============================================");
        System.out.printf("%-5s %-25s %-12s %-8s\n", "ID", "Producto", "Precio (Lps)", "Stock");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%-5d %-25s L. %-9.2f %-8d\n", (i + 1), productos[i], precios[i], stock[i]);
        }
        System.out.println("---------------------------------------------");
    }

   
    public static boolean existeProducto(int id) {
        return (id >= 1 && id <= productos.length);
    }

    // Valida disp. unidades para la venta
    public static boolean validarStockDisponible(int idProducto, int cantidadSolicitada) {
        int indice = idProducto - 1; // Convertir ID (1-5) a posición del arreglo (0-4)
        
        if (stock[indice] >= cantidadSolicitada) {
            return true;
        } else {
            System.out.println("\n[ERROR DE STOCK] No hay suficiente inventario.");
            System.out.println("Disponible actual: " + stock[indice] + " unidades.");
            return false;
        }
    }//fin de validarStockDisponible

    // Descuento
    public static void rebajarStock(int idProducto, int cantidadVendida) {
        int indice = idProducto - 1;
        stock[indice] = stock[indice] - cantidadVendida;
        System.out.println("-> Stock actualizado para " + productos[indice] + ". Nuevo stock: " + stock[indice]);
    }//fin de rebajarStock
    
}//fin de class
    

