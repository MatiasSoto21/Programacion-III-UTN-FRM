import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> partituras = List.of(
                new Producto("PAR-11", "Estudios para guitarra", 12500, "Clara Fuentes"),
                new Producto("PAR-12", "Ritmos del litoral", 9800, "Emilio Costa"),
                new Producto("PAR-13", "Primeros acordes", 7200, "Paula Ferrer")
        );
        List<ProductoDTO> catalogoPublico = new ArrayList<>();
        for (Producto partitura : partituras) {
            catalogoPublico.add(ProductoDTO.desde(partitura));
        }
        System.out.println("Catalogo: codigo, nombre y precio");
        catalogoPublico.forEach(System.out::println);
        // El DTO no tiene el campo autor; conserva solo los datos de esta vista.
        catalogoPublico.get(0).setPrecio(11900);
        System.out.println("Precio en el DTO: " + catalogoPublico.get(0).getPrecio());
        System.out.println("Precio en el objeto original: " + partituras.get(0).getPrecio());
    }
}
