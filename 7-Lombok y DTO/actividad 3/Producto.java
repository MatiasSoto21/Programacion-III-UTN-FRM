public class Producto {
    private final String codigo;
    private final String nombre;
    private final double precio;
    private final String autor;

    public Producto(String codigo, String nombre, double precio, String autor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + precio + " | " + autor;
    }
}
