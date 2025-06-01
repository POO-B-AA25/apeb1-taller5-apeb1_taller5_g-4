import java.util.ArrayList;

public class Disciplina {
    private String nombre;
    private ArrayList<Prueba> pruebas;

    public Disciplina(String nombre) {
        this.nombre = nombre;
        this.pruebas = new ArrayList<>();
    }

    public void agregarPrueba(Prueba prueba) {
        pruebas.add(prueba);
    }

    public String calcularEstadisticas() {
        int totalPruebas = 0;
        int totalParticipantes = 0;
        double sumaPromedios = 0;

        for (Prueba prueba : pruebas) {
            totalPruebas++;
            for (Participante p : prueba.obtenerParticipantesDestacados()) {
                totalParticipantes++;
                sumaPromedios += p.obtenerPromedio();
            }
        }

        double promedioGeneral = (totalParticipantes > 0) ? sumaPromedios / totalParticipantes : 0;

        return "Disciplina: " + nombre +
               "\nPruebas: " + totalPruebas +
               "\nParticipantes destacados: " + totalParticipantes +
               "\nPromedio general de destacados: " + promedioGeneral;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Disciplina: " + nombre + "\n");
        for (Prueba prueba : pruebas) {
            sb.append(prueba.toString()).append("\n");
        }
        return sb.toString();
    }
}
