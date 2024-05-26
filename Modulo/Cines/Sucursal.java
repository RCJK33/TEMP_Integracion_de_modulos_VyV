//clase sucursales que contiene las salas
package Modulo.Cines;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    protected int num;
    protected String nombre;
    protected String ubicacion;
    protected String rfc;
    protected boolean fueradeserv; // por defecto inicializa en false, true quiere decir que está fuera de servicio
    protected List<Sala> salas; // Lista de salas asociadas a esta sucursal

    public Sucursal() {
        this.num = 0;
        this.salas = new ArrayList<>();
    }

    public Sucursal(int num, String nombre, String ubicacion, String rfc, String fueradeserv) {
        this.num = num;
        setNombre(nombre);
        setUbicacion(ubicacion);
        setRfc(rfc);
        setFueradeserv(Boolean.valueOf(fueradeserv)); // convertimos string a boolean
        this.salas = new ArrayList<>();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public boolean isFueradeserv() {
        return fueradeserv;
    }

    public void setFueradeserv(boolean fueradeserv) {
        this.fueradeserv = fueradeserv;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return "Sucursal: " + nombre
        + " -- Ubicacion: " + ubicacion
        + " -- RFC:" + rfc
        + " --Fuera de servicio: " + fueradeserv + " ";
    }
}
