public class Alumno {
    private final String nombre;
    private final double nota;
    private final String curso;

    public Alumno(String nombre, double nota, String curso) {
        this.nombre = nombre;
        this.nota = nota;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return nombre + " | " + nota + " | " + curso;
    }
}
