
public class Departamento {
   String nombre;
    int empleados;
    double produccion;
    String categoria;

    public Departamento(String nombre, int empleados, double produccion) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.produccion = produccion;
        this.categoria = categorizar();
    }

    private String categorizar() {
        if (empleados > 20 && produccion > 1_000_000) return "A";
        else if (empleados >= 20 && produccion >= 1_000_000) return "B";
        else return "C";
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre +
               "\nEmpleados: " + empleados +
               "\nProducción: $" + produccion +
               "\nCategoría: " + categoria + "\n";
    }
}
