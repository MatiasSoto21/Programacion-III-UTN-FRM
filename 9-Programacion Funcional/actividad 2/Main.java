import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Alumno> taller = List.of(
                new Alumno("Renata", 9, "Maniana"),
                new Alumno("Facundo", 6, "Tarde"),
                new Alumno("Pilar", 8, "Maniana"),
                new Alumno("Santiago", 7, "Noche"),
                new Alumno("Abril", 10, "Tarde"),
                new Alumno("Dante", 5, "Noche")
        );
        List<String> aprobados = taller.stream()
                .filter(alumno -> alumno.getNota() >= 7)
                .map(alumno -> alumno.getNombre().toUpperCase(Locale.ROOT))
                .sorted()
                .toList();
        double promedio = taller.stream().mapToDouble(Alumno::getNota).average().orElse(0);
        Map<String, List<Alumno>> comisiones = taller.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso, TreeMap::new, Collectors.toList()));
        List<Alumno> destacados = taller.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed()
                        .thenComparing(Alumno::getNombre))
                .limit(3)
                .toList();

        System.out.println("Aprobados: " + aprobados);
        System.out.printf(Locale.ROOT, "Promedio del taller: %.2f%n", promedio);
        comisiones.forEach((curso, alumnos) -> System.out.println(curso + ": " + alumnos));
        System.out.println("Tres notas mas altas: " + destacados);
    }
}
