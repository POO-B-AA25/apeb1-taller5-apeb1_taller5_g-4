import java.util.Date;
public class Evento {
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private Date fecha;
    private boolean esBatalla;
    private boolean usoNuclear;
    private int porcentajeBajas;

    public Evento(String nombre, String ubicacion, String descripcion, Date fecha,
                  boolean esBatalla, boolean usoNuclear, int porcentajeBajas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.esBatalla = esBatalla;
        this.usoNuclear = usoNuclear;
        this.porcentajeBajas = porcentajeBajas;
    }

    public boolean esBatalla() {
        return esBatalla;
    }

    public boolean usoNuclear() {
        return usoNuclear;
    }

    public int getPorcentajeBajas() {
        return porcentajeBajas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha + ", Ubicación: " + ubicacion +
               ", Descripción: " + descripcion + ", Batalla: " + esBatalla +
               ", Nuclear: " + usoNuclear + ", % Bajas: " + porcentajeBajas;
    }
}
