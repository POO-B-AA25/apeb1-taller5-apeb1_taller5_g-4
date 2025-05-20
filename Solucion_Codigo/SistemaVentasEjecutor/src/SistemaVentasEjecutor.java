import java.util.*;
import java.util.Random;

public class SistemaVentasEjecutor {
    public static void main(String[] args) {
       Random random = new Random();
        List<Producto> carrito = new ArrayList<>();
        String[] nombres = {"Laptop", "Mouse", "Teclado", "Monitor", "USB", "Tablet"};

        for (int i = 0; i < 5; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            double precio = 10 + random.nextDouble() * 490;
            int cantidad = 1 + random.nextInt(5);
            carrito.add(new Producto(nombre, precio, cantidad));
        }

        double total = 0;
        System.out.println("Productos en el carrito:");
        for (Producto p : carrito) {
            System.out.println(p);
            total += p.calcularTotal();
        }
        System.out.printf("Total a pagar: $%.2f\n", total);
    }
}
