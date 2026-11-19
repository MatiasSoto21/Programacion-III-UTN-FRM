import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Producto> catalogo = new HashSet<>();
        Producto[] ingresos = {
            new Producto("CAM-10", "Carpa para dos personas"),
            new Producto("CAM-20", "Bolsa de dormir"),
            new Producto("CAM-30", "Linterna recargable"),
            new Producto("CAM-10", "Carpa con otra descripcion")
        };
        for (Producto producto : ingresos) {
            boolean agregado = catalogo.add(producto);
            System.out.println(producto.getCodigo() + (agregado ? " agregado" : " ya registrado"));
        }
        System.out.println("Productos distintos: " + catalogo.size());
        // HashSet no garantiza el orden de recorrido.
        for (Producto producto : catalogo) {
            System.out.println(producto);
        }
        System.out.println("Existe CAM-20: " +
                catalogo.contains(new Producto("CAM-20", "Consulta por codigo")));
    }
}
