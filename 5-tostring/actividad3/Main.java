public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso("Estructuras de Datos");
        curso1.agregarEstudiante(
            new Estudiante("Juan", 20, "Programación")
        );
        curso1.agregarEstudiante(
            new Estudiante("María", 22, "Programación")
        );

        Curso curso2 = new Curso("Bases de Datos");
        curso2.agregarEstudiante(
            new Estudiante("Pedro", 21, "Sistemas")
        );
        curso2.agregarEstudiante(
            new Estudiante("Lucía", 23, "Sistemas")
        );

        Curso curso3 = new Curso("Programación III");
        curso3.agregarEstudiante(
            new Estudiante("Carlos", 24, "Programación")
        );

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(curso3);
    }
}