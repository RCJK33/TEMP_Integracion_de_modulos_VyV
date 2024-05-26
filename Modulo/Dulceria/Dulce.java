

/**
 *
 * @author Gael
 */
public class Dulce extends Productos {

    // Atributos
    private String SKU;
    Tipo tipodulce; // Relacion
    Tipo a;
    Tipo b;
    // Setters y Getters
    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Tipo gettipodulce() {
        return tipodulce;
    }

    public Tipo getsa() {
        return a;
    }

    public Tipo getse() {
        return b;
    }

    public void settipodulce(Tipo tipodulce) {
        this.tipodulce = tipodulce;
    }
    public void sa(Tipo a) {
        this.a = a;
    }
    public void se(Tipo b) {
        this.b = b;
    }

    // Otros métodos
    @Override
    public String toString() {
        String nombre = "Nombre: " + getNombre();
        String precio = "Precio: " + "$"+ getPrecio();
        String tipo = "Tipo: " + tipodulce;
        String tamaño = "Tamaño: " + b;
        String sabor = "Sabor: " + a;
        String cantidad = "Cantidad: " + getCantidad();
        String sku = "SKU: " + SKU;

        // Calcular la longitud máxima de las líneas para establecer el ancho del cuadro
        int maxLength = Math.max(Math.max(nombre.length(), cantidad.length()), Math.max(Math.max(sku.length(), tamaño.length()), Math.max(sabor.length(), Math.max(tipo.length(), precio.length()))));

        // Construir el cuadro
        StringBuilder cuadro = new StringBuilder();
        cuadro.append("┌");
        cuadro.append("─".repeat(maxLength + 2));
        cuadro.append("┐\n");

        // Líneas con contenido
        cuadro.append("│ ").append(padRight(nombre, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(cantidad, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(sku, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(tamaño, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(sabor, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(tipo, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(precio, maxLength)).append(" │\n");

        // Línea inferior del cuadro
        cuadro.append("└");
        cuadro.append("─".repeat(maxLength + 2));
        cuadro.append("┘");

        return cuadro.toString();
    }
    private String padRight(String s, int length) {
    return String.format("%-" + length + "s", s);
}

}
