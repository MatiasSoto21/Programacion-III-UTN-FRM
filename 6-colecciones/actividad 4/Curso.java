public class Curso {
    private final String nombre;
    private final String docente;

    public Curso(String nombre, String docente) {
        this.nombre = nombre;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocente() {
        return docente;
    }

    @Override
    public String toString() {
        return nombre + " | " + docente;
    }
}
