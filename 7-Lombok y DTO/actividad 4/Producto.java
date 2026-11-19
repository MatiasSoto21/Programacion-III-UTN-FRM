public class Producto {
    private final String codigo;
    private final String nombre;
    private final String proveedor;
    private final double precio;

    public Producto(String codigo, String nombre, String proveedor, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + proveedor + " | " + precio;
    }
}
