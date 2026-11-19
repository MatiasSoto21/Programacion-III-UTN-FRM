import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void mostrarListaSinTipo() {
        // Ejemplo deliberado: la lista acepta tipos incompatibles entre si.
        List mezcla = new ArrayList();
        mezcla.add("Reserva de herramientas");
        mezcla.add(18);
        String descripcion = (String) mezcla.get(0);
        System.out.println("Con cast: " + descripcion);
        try {
            String numeroComoTexto = (String) mezcla.get(1);
            System.out.println(numeroComoTexto);
        } catch (ClassCastException error) {
            System.out.println("El cast del Integer a String falla al ejecutar.");
        }
    }

    public static void main(String[] args) {
        Caja<String> etiqueta = new Caja<>();
        etiqueta.guardar("Herramientas del laboratorio");
        Caja<Integer> cantidad = new Caja<>();
        cantidad.guardar(18);
        String texto = etiqueta.obtener();
        int unidades = cantidad.obtener();
        System.out.println(texto + ": " + unidades);

        mostrarListaSinTipo();
        List<String> herramientas = new ArrayList<>();
        herramientas.add("Multimetro");
        herramientas.add("Soldador");
        String primera = herramientas.get(0);
        System.out.println("Sin cast: " + primera);
        // herramientas.add(18); // No compila: esta lista solo admite String.
    }
}
