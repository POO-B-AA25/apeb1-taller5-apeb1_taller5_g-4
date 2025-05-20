import java.util.*;
public class Conflicto {
    private String nombre;
    private ArrayList<String> paisesInvolucrados;
    private Date fechaInicio;
    private String estado;
    private ArrayList<Evento> eventos;

    public Conflicto(String nombre, ArrayList<String> paisesInvolucrados, Date fechaInicio) {
        this.nombre = nombre;
        this.paisesInvolucrados = paisesInvolucrados;
        this.fechaInicio = fechaInicio;
        this.estado = "Iniciado";
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        evaluarEstado();
    }

    private void evaluarEstado() {
        int totalPaises = 195; // Aproximadamente
        int batallas = 0;
        int batallasEnDesarrollados = 0;
        boolean usoNuclear = false;
        boolean bajasMayoresAl50 = false;

        for (Evento e : eventos) {
            if (e.esBatalla()) {
                batallas++;
                if (esPaisDesarrollado(e.getUbicacion())) {
                    batallasEnDesarrollados++;
                    if (e.usoNuclear()) {
                        usoNuclear = true;
                    }
                }
                if (e.getPorcentajeBajas() >= 50) {
                    bajasMayoresAl50 = true;
                }
            }
        }

        int porcentajeBatallas = (batallas * 100) / totalPaises;

        if (porcentajeBatallas >= 50) {
            estado = "Guerra Mundial";
        } else if (porcentajeBatallas >= 30 || bajasMayoresAl50) {
            estado = "Reunión ONU Urgente";
        }

        if (batallasEnDesarrollados > 0 && usoNuclear) {
            estado = "Guerra Mundial";
        }
    }

    private boolean esPaisDesarrollado(String pais) {
        String[] desarrollados = {"Estados Unidos", "Alemania", "Francia", "Japón", "Canadá", "Reino Unido"};
        for (String p : desarrollados) {
            if (p.equalsIgnoreCase(pais)) {
                return true;
            }
        }
        return false;
    }

    public String getEstado() {
        return estado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conflicto: ").append(nombre).append("\nEstado Actual: ").append(estado)
          .append("\nFecha de inicio: ").append(fechaInicio).append("\nPaises: ").append(paisesInvolucrados)
          .append("\nEventos:\n");
        for (Evento e : eventos) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}
