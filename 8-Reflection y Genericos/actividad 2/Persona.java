public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String mostrarInformacion() {
        return nombre + ", " + edad + " anios";
    }

    private String saludar() {
        return "Bienvenido al taller, " + nombre;
    }
}
