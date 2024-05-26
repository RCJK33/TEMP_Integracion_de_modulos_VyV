package Modulo.Peliculas;
import java.util.Scanner;
public class Validar_Pelicula {

    Scanner ptr = new Scanner(System.in);

    public String validaNombre(){
        String nombre;
        do{
            System.out.println("Ingresa Nombre de la Pelicula:");
            nombre = ptr.nextLine();
        }while(!Validaciones.soloStr(nombre) && !Validaciones.strYnum(nombre));
        return Validaciones.primeraMayus(nombre);
    }

    public String validaDuracion(){
        String duracion;
        do{
            System.out.println("Ingresa Duración de la Pelicula (En minutos): ");
            duracion = ptr.nextLine();
        }while(!Validaciones.solonums(duracion));
        return duracion;
    }

    public String validaClasificacion() {
        String clasificacion;
        do {
            System.out.println("Ingresa Clasificación de la Película: ");
            clasificacion = ptr.nextLine();
        } while (Validaciones.comienzaConNumero(clasificacion));
        return clasificacion.toUpperCase();
    }
    

    public String validaCategoria(){
        String categoria;
        do{
            System.out.println("Ingresa Categoría de la Pelicula:");
            categoria = ptr.nextLine();
        }while(!Validaciones.soloStr(categoria));
        return Validaciones.primeraMayus(categoria);
    }

    public String validaOpcion(){
        String opcion;
        do{
            System.out.println("Ingrese una de las opciones supeiores.");
            opcion = ptr.nextLine();
        }while(!Validaciones.solonums(opcion));
        return opcion;
    }
 
}
