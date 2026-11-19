import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<Persona> tipo = Persona.class;
        for (Constructor<?> constructor : tipo.getDeclaredConstructors()) {
            System.out.println("Constructor disponible: " + constructor);
        }
        Persona asistente = tipo.getDeclaredConstructor(String.class, int.class)
                .newInstance("Agustin", 27);
        Method informacion = tipo.getDeclaredMethod("mostrarInformacion");
        System.out.println("Antes: " + informacion.invoke(asistente));

        Field nombre = tipo.getDeclaredField("nombre");
        nombre.setAccessible(true);
        try {
            nombre.set(asistente, "Agustin Navarro");
        } finally {
            nombre.setAccessible(false);
        }

        Method saludo = tipo.getDeclaredMethod("saludar");
        saludo.setAccessible(true);
        try {
            System.out.println(saludo.invoke(asistente));
        } finally {
            saludo.setAccessible(false);
        }
        System.out.println("Despues: " + informacion.invoke(asistente));
        System.out.println("Acceso al metodo privado restablecido: " + saludo.canAccess(asistente));
        // La clase conserva su metodo private. La excepcion de acceso fue temporal.
    }
}
