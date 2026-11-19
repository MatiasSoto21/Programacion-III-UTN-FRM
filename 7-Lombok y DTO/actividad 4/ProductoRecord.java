public record ProductoRecord(String codigo, String nombre, double precio) {
    public static ProductoRecord desde(Producto producto) {
        return new ProductoRecord(producto.getCodigo(), producto.getNombre(), producto.getPrecio());
    }
}
