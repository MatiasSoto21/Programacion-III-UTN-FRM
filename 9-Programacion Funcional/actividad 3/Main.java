import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> local = List.of(
                new Producto("Taladro", "Herramientas", 180, 4),
                new Producto("Martillo", "Herramientas", 35, 12),
                new Producto("Carretilla", "Jardin", 140, 3),
                new Producto("Manguera", "Jardin", 65, 8),
                new Producto("Lampara", "Electricidad", 25, 20),
                new Producto("Reflector", "Electricidad", 155, 5)
        );
        List<Producto> seleccion = local.stream()
                .filter(producto -> producto.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .toList();
        Map<String, Integer> existencias = local.stream().collect(Collectors.groupingBy(
                Producto::getCategoria, TreeMap::new, Collectors.summingInt(Producto::getStock)));
        String reporte = local.stream()
                .map(producto -> String.format(Locale.ROOT, "%s ($%.2f)",
                        producto.getNombre(), producto.getPrecio()))
                .collect(Collectors.joining("; "));
        double promedio = local.stream().mapToDouble(Producto::getPrecio).average().orElse(0);
        Map<String, Double> promedios = local.stream().collect(Collectors.groupingBy(
                Producto::getCategoria, TreeMap::new, Collectors.averagingDouble(Producto::getPrecio)));

        System.out.println("Precio mayor a 100, de mayor a menor: " + seleccion);
        System.out.println("Unidades por categoria: " + existencias);
        System.out.println("Catalogo: " + reporte);
        // Promedio de precios unitarios, sin ponderar por stock.
        System.out.printf(Locale.ROOT, "Precio promedio general: %.2f%n", promedio);
        promedios.forEach((categoria, valor) ->
                System.out.printf(Locale.ROOT, "%s: %.2f%n", categoria, valor));
    }
}
