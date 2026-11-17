import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private List<Estudiante> listaDeEstudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.listaDeEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaDeEstudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        String resultado = "Curso: " + nombre + "\n";
        resultado += "Cantidad de alumnos: " +
                     listaDeEstudiantes.size() + "\n";
        resultado += "Estudiantes:\n";

        for (Estudiante estudiante : listaDeEstudiantes) {
            resultado += "- " + estudiante.toString() + "\n";
        }

        return resultado;
    }
}