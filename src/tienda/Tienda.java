
package tienda;

import java.util.Scanner;

public class Tienda {

    static Almacen almacen;
    static Scanner entrada = new Scanner(System.in);
    static double total = 0;
    
    public static void main(String[] args) {
        almacen = new Almacen();
        almacen.productos.add(new Producto("Leche", 0.8, 3));
        almacen.productos.add(new Producto("Jamón", 8, 1));
        almacen.productos.add(new Producto("Magdalenas", 2.3, 5));
        almacen.productos.add(new Producto("Huevos", 1.4, 1));
        
       mostrarProductosYPedirProducto();
       despedida();
    }
    
    private static void mostrarProductosYPedirProducto() {
        int elegido = 0;
        while(elegido != 9) { // Salir si se selecciona el producto 9
            mostrarProductos();

            System.out.print("Elige un producto (9 para salir): ");
            elegido = entrada.nextInt();

            if (elegido == 9) continue; // Salir si se selecciona el producto 9 
            
            if (almacen.productos.get(elegido - 1).GetExistencias() > 0) {
                System.out.println("Vendido.");
                total = total + almacen.productos.get(elegido - 1).PRECIO;
                almacen.productos.get(elegido - 1).vender();
            } else {
                System.out.println("Producto agotado");
                almacen.productos.remove(elegido - 1);
            }
        }
    }
    
    private static void despedida() {
        System.out.println("Total a pagar: " + total);
        System.out.println("Gracias por su visita");
    }
    
    private static void mostrarProductos() {
        System.out.println("LISTA DE PRODUCTOS");
        int i = 1;
        for (Producto producto : almacen.productos) {
            System.out.println(i +  ". " + producto.nombre + " " + producto.PRECIO);
            i++;
        }
    }
    
}
