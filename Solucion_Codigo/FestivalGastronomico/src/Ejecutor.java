import java.util.Scanner;

class Expositor {
    private int id;
    private String nombre;
    private String pais;
    private Plato plato1;
    private Plato plato2;

    public Expositor(int id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public void registrarPlato(Plato plato) {
        if (plato1 == null) {
            plato1 = plato;
        } else if (plato2 == null) {
            plato2 = plato;
        } else {
            System.out.println("Este expositor ya tiene el máximo de platos registrados.");
        }
    }

    public float calcularIngresos() {
        float total = 0;
        if (plato1 != null) total += plato1.calcularIngresos();
        if (plato2 != null) total += plato2.calcularIngresos();
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public Plato getPlato1() { return plato1; }
    public Plato getPlato2() { return plato2; }
}

class Plato {
    private int id;
    private String nombre;
    private float precio;
    private boolean disponible;
    private int vendidos;
    private Ingrediente ingrediente1;
    private Ingrediente ingrediente2;
    private Ingrediente ingrediente3;
    private Expositor expositor;

    public Plato(int id, String nombre, float precio, Expositor expositor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.expositor = expositor;
        this.disponible = true;
        this.vendidos = 0;
    }

    public void registrarVenta(int cantidad) {
        if (disponible) {
            vendidos += cantidad;
        } else {
            System.out.println("El plato no esta disponible para la venta.");
        }
    }

    public void marcarNoDisponible() {
        disponible = false;
    }

    public float calcularIngresos() {
        return precio * vendidos;
    }

    public void agregarIngrediente(Ingrediente i1, Ingrediente i2, Ingrediente i3) {
        this.ingrediente1 = i1;
        this.ingrediente2 = i2;
        this.ingrediente3 = i3;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVendidos() {
        return vendidos;
    }

    public Expositor getExpositor() {
        return expositor;
    }
}

class Ingrediente {
    private int id;
    private String nombre;
    private String cantidad;

    public Ingrediente(int id, String nombre, String cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}

class Reporte {
    public void generarTopPlatos(Plato p1, Plato p2) {
        System.out.println("\n--- Platos Mas Vendidos ---");
        if (p1.getVendidos() > p2.getVendidos()) {
            System.out.println(p1.getNombre() + " con " + p1.getVendidos() + " vendidos.");
        } else if (p2.getVendidos() > p1.getVendidos()) {
            System.out.println(p2.getNombre() + " con " + p2.getVendidos() + " vendidos.");
        } else {
            System.out.println("Ambos platos tienen la misma cantidad de ventas.");
        }
    }

    public void generarTopExpositores(Expositor e1, Expositor e2) {
        System.out.println("\n--- Stands con Mayor Movimiento ---");
        float ingresos1 = e1.calcularIngresos();
        float ingresos2 = e2.calcularIngresos();
        if (ingresos1 > ingresos2) {
            System.out.println(e1.getNombre() + " con $" + ingresos1);
        } else if (ingresos2 > ingresos1) {
            System.out.println(e2.getNombre() + " con $" + ingresos2);
        } else {
            System.out.println("Ambos expositores generaron los mismos ingresos.");
        }
    }

    public void mostrarResumen(Expositor e1, Expositor e2) {
        System.out.println("\n--- Resumen General ---");
        System.out.println(e1.getNombre() + " genero: $" + e1.calcularIngresos());
        System.out.println(e2.getNombre() + " genero: $" + e2.calcularIngresos());
    }
}

public class Ejecutor {
    public static void main(String[] args) {
        Expositor expositor1 = new Expositor(1, "Sabores del Peru", "Peru");
        Expositor expositor2 = new Expositor(2, "Tacos Azteca", "Mexico");

        Plato ceviche = new Plato(1, "Ceviche", 8.5f, expositor1);
        Plato tacos = new Plato(2, "Tacos al Pastor", 5.0f, expositor2);

        expositor1.registrarPlato(ceviche);
        expositor2.registrarPlato(tacos);

        Ingrediente i1 = new Ingrediente(1, "Pescado", "200g");
        Ingrediente i2 = new Ingrediente(2, "Limon", "50ml");
        Ingrediente i3 = new Ingrediente(3, "Cebolla", "30g");

        Ingrediente j1 = new Ingrediente(4, "Tortilla", "2 piezas");
        Ingrediente j2 = new Ingrediente(5, "Carne al pastor", "100g");
        Ingrediente j3 = new Ingrediente(6, "Piña", "20g");

        ceviche.agregarIngrediente(i1, i2, i3);
        tacos.agregarIngrediente(j1, j2, j3);

        // Simular ventas
        ceviche.registrarVenta(20);
        tacos.registrarVenta(35);

        Reporte reporte = new Reporte();
        reporte.generarTopPlatos(ceviche, tacos);
        reporte.generarTopExpositores(expositor1, expositor2);
        reporte.mostrarResumen(expositor1, expositor2);
    }
}
