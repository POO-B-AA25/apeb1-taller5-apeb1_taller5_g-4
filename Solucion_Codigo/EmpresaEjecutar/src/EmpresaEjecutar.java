import java.util.*;
import java.util.Random;

public class EmpresaEjecutar {
   
    public static void main(String[] args) {
      Random random = new Random();
        String[] nombres = {"Producción", "Ventas", "Recursos Humanos", "Logística", "Finanzas"};
        List<Departamento> departamentos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            int empleados = 5 + random.nextInt(30);
            double produccion = 100_000 + random.nextDouble() * 2_000_000;
            departamentos.add(new Departamento(nombre, empleados, produccion));
        }

        System.out.println("Resultados:");
        for (Departamento d : departamentos) {
            System.out.println(d);
        }
    }
}

