
public class Persona {
    private String nombre;
    private int edad;
    private String ocupacion;
    private String implicacion; // "acusado", "testigo", "víctima"
    private boolean colabora;
    private double sentenciaAnios;
    private double danoEconomico;

    public Persona(String nombre, int edad, String ocupacion, String implicacion, boolean colabora, double sentenciaAnios, double danoEconomico) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.implicacion = implicacion.toLowerCase();
        this.colabora = colabora;
        this.sentenciaAnios = sentenciaAnios;
        this.danoEconomico = danoEconomico;
    }

    public boolean puedePagarFianza() {
        return implicacion.equals("acusado") && colabora && sentenciaAnios < 1;
    }

    public double calcularFianzaMaxima() {
        if (puedePagarFianza()) {
            return danoEconomico * 0.5;
        }
        return 0;
    }

    public boolean tieneReduccionPena() {
        return implicacion.equals("acusado") && colabora;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nOcupación: " + ocupacion +
               "\nImplicación: " + implicacion + "\nColabora: " + (colabora ? "Sí" : "No") +
               "\nSentencia: " + sentenciaAnios + " años" +
               "\nDaño Económico: $" + danoEconomico +
               (puedePagarFianza() ? "\nPuede pagar fianza hasta: $" + calcularFianzaMaxima() : "") +
               (tieneReduccionPena() ? "\nAplica a reducción de pena por colaboración." : "") + "\n";
    }
}
