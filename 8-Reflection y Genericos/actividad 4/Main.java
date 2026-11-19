import java.util.List;

public class Main {
    public static <T> void imprimirLista(List<T> elementos) {
        int posicion = 1;
        for (T elemento : elementos) {
            System.out.println(posicion++ + ") " + elemento);
        }
    }

    public static void main(String[] args) {
        List<Integer> distancias = List.of(5, 12, 21);
        List<String> destinos = List.of("Potrerillos", "Cacheuta", "Uspallata");
        System.out.println("Distancias en kilometros:");
        imprimirLista(distancias);
        System.out.println("Destinos de las salidas:");
        imprimirLista(destinos);
        System.out.println("Una lista vacia no imprime elementos:");
        imprimirLista(List.<String>of());
    }
}
