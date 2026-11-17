import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        Producto p1 = new Producto("P001", "Teclado", 15000);
        Producto p2 = new Producto("P002", "Mouse", 8500);
        Producto p3 = new Producto("P003", "Monitor", 120000);
        Producto p4 = new Producto("P001", "Teclado Gamer", 25000);

        Producto[] nuevosProductos = {p1, p2, p3, p4};

        for (Producto producto : nuevosProductos) {
            if (!productos.contains(producto)) {
                productos.add(producto);
                System.out.println("Producto agregado: " + producto);
            } else {
                System.out.println("Producto duplicado, no se agrega: " + producto);
            }
        }

        System.out.println("\nLista final de productos:");

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}