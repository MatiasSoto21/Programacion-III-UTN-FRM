public class Main {
    public static void main(String[] args) {
        Usuario bibliotecaria = Usuario.builder()
                .nombre("Victoria Acosta")
                .email("victoria@biblioteca.example")
                .id(41L)
                .build();
        Usuario lector = Usuario.builder()
                .id(42L)
                .nombre("Nicolas Vera")
                .email("nicolas@correo.example")
                .build();

        System.out.println("Encargada: " + bibliotecaria);
        lector.setEmail("nicolas.vera@correo.example");
        System.out.println("Contacto del lector: " + lector.getEmail());
        Usuario mismaEncargada = Usuario.builder()
                .id(41L)
                .nombre("Victoria Acosta")
                .email("victoria@biblioteca.example")
                .build();
        System.out.println("Iguales por sus datos: " + bibliotecaria.equals(mismaEncargada));
    }
}
