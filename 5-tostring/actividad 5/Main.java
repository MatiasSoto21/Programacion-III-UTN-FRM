import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Producto> productos = new HashSet<>();

        Producto p1 = new Producto("P001", "Teclado", 15000);
        Producto p2 = new Producto("P002", "Mouse", 8500);
        Producto p3 = new Producto("P003", "Monitor", 120000);
        Producto p4 = new Producto("P001", "Teclado Gamer", 25000);
        Producto p5 = new Producto("P002", "Mouse Inalambrico", 18000);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        System.out.println("Cantidad de productos: " + productos.size());

        System.out.println("\nProductos almacenados:");

        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("\n¿p1 es igual a p4? " + p1.equals(p4));
        System.out.println("Hash de p1: " + p1.hashCode());
        System.out.println("Hash de p4: " + p4.hashCode());
    }
}