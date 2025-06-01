import java.util.ArrayList;

public class Participante {
    private String nombre;
    private int edad;
    private String universidad;
    private ArrayList<Double> puntajes;
    private ArrayList<Boolean> asistencias;

    public Participante(String nombre, int edad, String universidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.universidad = universidad;
        this.puntajes = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    public void registrarAsistencia(boolean asiste) {
        asistencias.add(asiste);
    }

    public void registrarPuntaje(double puntaje) {
        puntajes.add(puntaje);
    }

    public double obtenerPromedio() {
        if (puntajes.isEmpty()) return 0;
        double suma = 0;
        for (double p : puntajes) suma += p;
        return suma / puntajes.size();
    }

    public int pruebasSuperadas() {
        int count = 0;
        for (double p : puntajes) {
            if (p >= 60) count++; 
        }
        return count;
    }

    @Override
    public String toString() {
        return "Participante: " + nombre +
               " | Edad: " + edad +
               " | Universidad: " + universidad +
               " | Promedio: " + obtenerPromedio() +
               " | Pruebas superadas: " + pruebasSuperadas();
    }
}
