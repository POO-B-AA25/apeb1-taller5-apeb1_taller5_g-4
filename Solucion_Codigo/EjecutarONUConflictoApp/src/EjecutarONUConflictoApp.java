import java.util.*;
import java.util.Random;
import java.util.Date;


public class EjecutarONUConflictoApp {

    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Ecuador");
        paises.add("Colombia");
        paises.add("Estados Unidos");
        paises.add("Rusia");
        paises.add("Ucrania");

        Conflicto conflicto = new Conflicto("Conflicto Mundial Imaginario", paises, new Date());

        String[] ubicaciones = {"Ecuador", "Colombia", "Estados Unidos", "Rusia", "Ucrania", "Francia", "Alemania"};
        String[] descripciones = {
            "Batalla en la frontera", "Tratado de paz temporal", "Reunión diplomática fallida",
            "Enfrentamiento naval", "Uso de drones en combate", "Explosión nuclear", "Alianza política"
        };

        for (int i = 0; i < 10; i++) {
            String ubicacion = ubicaciones[rand.nextInt(ubicaciones.length)];
            String descripcion = descripciones[rand.nextInt(descripciones.length)];
            boolean esBatalla = rand.nextBoolean();
            boolean usoNuclear = rand.nextInt(10) < 2; // 20% chance
            int porcentajeBajas = rand.nextInt(101); // 0 - 100%

            Evento evento = new Evento(
                "Evento " + (i + 1),
                ubicacion,
                descripcion,
                new Date(),
                esBatalla,
                usoNuclear,
                porcentajeBajas
            );
            conflicto.agregarEvento(evento);
        }

        System.out.println(conflicto.toString());
    }
}
    