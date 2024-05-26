package Modulo.Peliculas;

public class Peliculas {
    private String nombre;
    private String duracion;
    private String clasificacion;
    private String categorias;

    public Peliculas(String nombre, String duracion, String clasificacion, String categorias) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return
        "Nombre: " + nombre + "\n" +
        "Duracion: " + duracion + " minutos" + "\n" +
        "Clasificacion: " + clasificacion + "\n" +
        "Categoria: " + categorias + "\n";
    }

    public String toString2() {
        return
        nombre + ", " + duracion + ", " + clasificacion + ", " + categorias;
    }




}
