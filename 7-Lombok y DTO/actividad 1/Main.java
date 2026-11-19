public class Main {
    public static void main(String[] args) {
        Persona coordinadora = new Persona("Rocio Benitez", 32);
        Persona participante = new Persona();
        participante.setNombre("Leandro Sosa");
        participante.setEdad(23);

        Persona[] equipo = {coordinadora, participante};
        for (Persona persona : equipo) {
            System.out.println(persona.getNombre() + " tiene " + persona.getEdad() + " anios");
        }
        participante.setEdad(participante.getEdad() + 1);
        System.out.println("Edad actualizada: " + participante.getEdad());
    }
}
