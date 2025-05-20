import java.util.Random;

public class EjecutorCalificaciones {


    public static void main(String[] args) {
     Random random = new Random();
        int M = 10;
        double[][] C = new double[M][6];

        // Llenar con datos aleatorios
        for (int i = 0; i < M; i++)
            for (int j = 0; j < 6; j++)
                C[i][j] = 5 + random.nextDouble() * 5;

        // a) Promedio por estudiante
        System.out.println("Promedio por estudiante:");
        for (int i = 0; i < M; i++) {
            double promedio = NotasEstudiantes.promedioEstudiante(C[i]);
            System.out.printf("Estudiante %d: %.2f\n", i + 1, promedio);
        }

        // b, c, d por materia
        for (int j = 0; j < 6; j++) {
            int aprobados = NotasEstudiantes.contarAprobados(C, j);
            int reprobados = NotasEstudiantes.contarReprobados(C, j);
            double promedio = NotasEstudiantes.promedioMateria(C, j);
            System.out.printf("\nMateria %d:\nAprobados: %d\nReprobados: %d\nPromedio: %.2f\n",
                    j + 1, aprobados, reprobados, promedio);
        }
    }
}  
