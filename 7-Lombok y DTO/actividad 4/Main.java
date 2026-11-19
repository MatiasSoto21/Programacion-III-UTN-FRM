import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> vivero = List.of(
                new Producto("VIV-01", "Lavanda", "Cultivos del Valle", 3500),
                new Producto("VIV-02", "Romero", "Semillas Andinas", 2800),
                new Producto("VIV-03", "Jazmin", "Cultivos del Valle", 6200)
        );
        for (Producto planta : vivero) {
            ProductoRecord ficha = ProductoRecord.desde(planta);
            System.out.println(ficha);
            System.out.println("Nombre mediante accessor: " + ficha.nombre());
        }
        ProductoRecord primera = ProductoRecord.desde(vivero.get(0));
        ProductoRecord otra = new ProductoRecord("VIV-01", "Lavanda", 3500);
        System.out.println("Records iguales por valor: " + primera.equals(otra));
        // No hay setters: cada record representa una ficha inmutable sin proveedor.
    }
}
