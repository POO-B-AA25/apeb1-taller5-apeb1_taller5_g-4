import java.time.LocalDate;
import java.util.Random;

public class FiscaliaEjecutar {

   
    public static void main(String[] args) {
        Fiscalia fiscalia = new Fiscalia();
        Random rand = new Random();

        String[] nombresCasos = {"Caso PetroCorrupción", "Operación Justicia Limpia", "Caso Odebrecht", "Red Judicial", "Dinero Oculto"};
        String[] detallesCasos = {"Corrupción en contratos estatales", "Malversación de fondos", "Coimas en obras públicas", "Tráfico de influencias", "Lavado de activos"};
        String[] nombresPersonas = {"Juan Pérez", "María Gómez", "Luis Torres", "Ana Sánchez", "Pedro Chávez", "Carmen Ruiz"};
        String[] ocupaciones = {"Abogado", "Empresario", "Juez", "Funcionario", "Contratista", "Contador"};
        String[] implicaciones = {"acusado", "testigo", "víctima"};

        int cantidadCasos = rand.nextInt(3) + 2; // 2 a 4 casos
        for (int i = 0; i < cantidadCasos; i++) {
            String nombreCaso = nombresCasos[rand.nextInt(nombresCasos.length)];
            String detalle = detallesCasos[rand.nextInt(detallesCasos.length)];
            LocalDate fecha = LocalDate.now().minusDays(rand.nextInt(20)); // Hasta 20 días en el pasado

            CasoCorrupcion caso = new CasoCorrupcion(nombreCaso, fecha, detalle);

            int personasEnCaso = rand.nextInt(4) + 2; // 2 a 5 personas
            for (int j = 0; j < personasEnCaso; j++) {
                String nombrePersona = nombresPersonas[rand.nextInt(nombresPersonas.length)];
                int edad = rand.nextInt(30) + 30; // 30 a 59 años
                String ocupacion = ocupaciones[rand.nextInt(ocupaciones.length)];
                String implicacion = implicaciones[rand.nextInt(implicaciones.length)];
                boolean colabora = rand.nextBoolean();
                double sentencia = implicacion.equals("acusado") ? rand.nextDouble() * 3 : 0; // hasta 3 años
                double dano = implicacion.equals("acusado") ? rand.nextDouble() * 100_000 : 0;

                Persona persona = new Persona(nombrePersona, edad, ocupacion, implicacion, colabora, sentencia, dano);
                caso.agregarPersona(persona);
            }

            fiscalia.agregarCaso(caso);
        }

        // Mostrar todos los casos generados
        fiscalia.mostrarTodosLosCasos();
    }
}
