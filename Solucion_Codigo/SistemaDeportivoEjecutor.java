public class SistemaDeportivoEjecutor {
    public static void main(String[] args) {

        Participante p1 = new Participante("Ana", 20, "UNI");
        p1.registrarAsistencia(true);
        p1.registrarPuntaje(85);
        p1.registrarPuntaje(90);

        Participante p2 = new Participante("Luis", 22, "UNMSM");
        p2.registrarAsistencia(true);
        p2.registrarPuntaje(70);
        p2.registrarPuntaje(75);

        Prueba prueba1 = new Prueba("Carrera 100m");
        prueba1.agregarParticipante(p1);
        prueba1.agregarParticipante(p2);

        Disciplina atletismo = new Disciplina("Atletismo");
        atletismo.agregarPrueba(prueba1);

        SistemaDeportivo sistema = new SistemaDeportivo();
        sistema.agregarDisciplina(atletismo);

        System.out.println(sistema.reporteGeneral());
    }
}
