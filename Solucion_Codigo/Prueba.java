import java.util.ArrayList;

public class Prueba {
    private String nombre;
    private ArrayList<Participante> participantes;

    public Prueba(String nombre) {
        this.nombre = nombre;
        this.participantes = new ArrayList<>();
    }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public ArrayList<Participante> obtenerParticipantesDestacados() {
        ArrayList<Participante> destacados = new ArrayList<>();
        for (Participante p : participantes) {
            if (p.obtenerPromedio() >= 80) {
                destacados.add(p);
            }
        }
        return destacados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Prueba: " + nombre + "\n");
        for (Participante p : participantes) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
