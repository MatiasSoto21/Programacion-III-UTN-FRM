import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Curso> talleres = new HashMap<>();
        talleres.put("FOT", new Curso("Fotografia inicial", "Ines Molina"));
        talleres.put("CER", new Curso("Ceramica", "Tomas Rios"));
        talleres.put("HUE", new Curso("Huerta urbana", "Valeria Paz"));

        String codigo = "CER";
        System.out.println("Consulta " + codigo + ": " + talleres.get(codigo));
        Curso anterior = talleres.put("CER", new Curso("Ceramica avanzada", "Tomas Rios"));
        System.out.println("Curso reemplazado: " + anterior);
        System.out.println("Cantidad de claves: " + talleres.size());

        if (!talleres.containsKey("MUS")) {
            System.out.println("MUS no esta disponible.");
        }
        for (Map.Entry<String, Curso> taller : talleres.entrySet()) {
            System.out.println(taller.getKey() + " -> " + taller.getValue());
        }
    }
}
