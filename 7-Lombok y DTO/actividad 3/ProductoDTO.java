public class ProductoDTO {
    private String codigo;
    private String nombre;
    private double precio;

    public ProductoDTO() { }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public static ProductoDTO desde(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setCodigo(producto.getCodigo());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " ($" + precio + ")";
    }
}
