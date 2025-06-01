import java.util.ArrayList;

public class SistemaDeportivo {
    private ArrayList<Disciplina> disciplinas;

    public SistemaDeportivo() {
        disciplinas = new ArrayList<>();
    }

    public void agregarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public String reporteGeneral() {
        StringBuilder sb = new StringBuilder("REPORTE GENERAL DEL EVENTO DEPORTIVO\n");
        for (Disciplina d : disciplinas) {
            sb.append(d.calcularEstadisticas()).append("\n\n");
        }
        return sb.toString();
    }
}
