
package tienda;

public class Producto {
    public String nombre;
    public double PRECIO;
    private int existencias;
    
    Producto(String nombre, double PRECIO, int existencias) {
        this.nombre = nombre;
        this.PRECIO = PRECIO;
        this.existencias = existencias;
    }
    
    public int GetExistencias() {
        return existencias;
    }
    
    public void vender() {
        this.existencias--;
    }
}
