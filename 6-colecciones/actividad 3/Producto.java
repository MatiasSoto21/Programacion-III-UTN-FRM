import java.util.Objects;

public class Producto {
    private final String codigo;
    private final String descripcion;

    public Producto(String codigo, String descripcion) {
        this.codigo = Objects.requireNonNull(codigo);
        this.descripcion = descripcion;
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }

    @Override
    public boolean equals(Object objeto) {
        return objeto instanceof Producto otro && codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode() { return codigo.hashCode(); }

    @Override
    public String toString() { return codigo + ": " + descripcion; }
}
