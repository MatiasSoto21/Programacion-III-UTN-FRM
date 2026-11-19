import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Alumno> inscriptos = new ArrayList<>();
        Alumno recursante = new Alumno("Malena", 6.5);
        inscriptos.add(new Alumno("Ramiro", 8));
        inscriptos.add(recursante);
        inscriptos.add(new Alumno("Julieta", 9));
        inscriptos.add(recursante);

        System.out.println("Inscripciones al taller: " + inscriptos.size());
        for (int posicion = 0; posicion < inscriptos.size(); posicion++) {
            System.out.println((posicion + 1) + ". " + inscriptos.get(posicion));
        }
        // ArrayList conserva el orden y admite repetir incluso la misma instancia.
        System.out.println("Primera inscripcion de Malena: " + inscriptos.indexOf(recursante));
        inscriptos.remove(recursante);
        System.out.println("Luego de cancelar una inscripcion: " + inscriptos.size());
        System.out.println("Todavia figura Malena: " + inscriptos.contains(recursante));
    }
}
