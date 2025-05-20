public class NotasEstudiantes {
    public static double promedioEstudiante(double[] notas) {
        double suma = 0;
        for (double nota : notas) suma += nota;
        return suma / notas.length;
    }

    public static int contarAprobados(double[][] matriz, int materia) {
        int contador = 0;
        for (double[] fila : matriz)
            if (fila[materia] >= 7) contador++;
        return contador;
    }

    public static int contarReprobados(double[][] matriz, int materia) {
        int contador = 0;
        for (double[] fila : matriz)
            if (fila[materia] < 7) contador++;
        return contador;
    }

    public static double promedioMateria(double[][] matriz, int materia) {
        double suma = 0;
        for (double[] fila : matriz) suma += fila[materia];
        return suma / matriz.length;
    }
}
