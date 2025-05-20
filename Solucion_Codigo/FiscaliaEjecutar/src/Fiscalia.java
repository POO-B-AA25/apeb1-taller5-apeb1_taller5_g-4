import java.util.ArrayList;

public class Fiscalia {
    private ArrayList<CasoCorrupcion> casos;

    public Fiscalia() {
        this.casos = new ArrayList<>();
    }

    public void agregarCaso(CasoCorrupcion caso) {
        casos.add(caso);
    }

    public void mostrarTodosLosCasos() {
        if (casos.isEmpty()) {
            System.out.println("No hay casos registrados.");
        } else {
            for (CasoCorrupcion caso : casos) {
                System.out.println("=====================================");
                caso.mostrarDetalles();
            }
        }
    }

    public CasoCorrupcion buscarCasoPorNombre(String nombre) {
        for (CasoCorrupcion caso : casos) {
            if (caso.getNombre().equalsIgnoreCase(nombre)) {
                return caso;
            }
        }
        return null;
    }
}
