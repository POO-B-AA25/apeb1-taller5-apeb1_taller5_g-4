
public class Producto {
   String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double calcularTotal() {
        return precio * cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " x " + cantidad + " = $" + calcularTotal();
    } 
}
