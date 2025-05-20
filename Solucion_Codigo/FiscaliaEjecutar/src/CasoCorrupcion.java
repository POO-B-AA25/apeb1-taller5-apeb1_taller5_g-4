import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class CasoCorrupcion {
    private String nombre;
    private LocalDate fechaInicio;
    private String estado; // Iniciado, Alerta, Urgente, Cerrado
    private String detalle;
    private ArrayList<Persona> implicados;

    public CasoCorrupcion(String nombre, LocalDate fechaInicio, String detalle) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.detalle = detalle;
        this.estado = "Iniciado";
        this.implicados = new ArrayList<>();
    }

    public void actualizarEstado() {
        long dias = ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());

        if (dias > 14) {
            estado = "Urgente";
        } else if (dias > 7) {
            estado = "Alerta";
        } else {
            estado = "Iniciado";
        }
    }

    public void agregarPersona(Persona p) {
        implicados.add(p);
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarDetalles() {
        actualizarEstado();
        System.out.println("Caso: " + nombre + "\nFecha de Inicio: " + fechaInicio +
                           "\nEstado Actual: " + estado + "\nDetalle: " + detalle);
        System.out.println("Implicados:");
        for (Persona p : implicados) {
            System.out.println(p);
        }
    }
}
