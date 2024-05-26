//clase salas
package Modulo.Cines;

public class Sala {
    Sucursal sucursal;
    protected String codigo; //codigo de sala para poder diferenciarla de las demas

    protected String tamano; //Grande: 400 asientos, Mediana: 200 asientos, Pequena: 100 asientos
    protected String numasientos;
    protected String tiposala; //3D, Megapantallas, Normales, 4D
    protected boolean fueradeserv; //por defecto inicializa en false, true quiere decir que esta fuera de servicio

    public Sala(){
        this.tamano = "";
        this.tiposala = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Sucursal getSucursal() {
        return sucursal;
    }


    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getTiposala() {
        return tiposala;
    }

    public void setTiposala(String tiposala) {
        this.tiposala = tiposala;
    }

    public boolean isFueradeserv() {
        return fueradeserv;
    }

    public void setFueradeserv(boolean fueradeserv) {
        this.fueradeserv = fueradeserv;
    }

    public String getNumasientos() {
        return numasientos;
    }

    public void setNumasientos(String numasientos) {
        this.numasientos = numasientos;
    }

    @Override
    public String toString() {
        return "Sala [tamano=" + tamano
                + ", numasientos=" + numasientos + ", tiposala=" + tiposala + ", fueradeserv=" + fueradeserv + "]";
    }



}
