/**
 *
 * @author Gael
 */
public class Tipo {

    // Atributos
    private String codigo;

    // Constructores
    public Tipo() {
        this.codigo = "";
    }

    public Tipo(String codigo) {
        this.codigo = codigo;
    }



    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    // Otros métodos
    @Override
    public String toString() {
        return "[" + codigo + "]";
    }

}
