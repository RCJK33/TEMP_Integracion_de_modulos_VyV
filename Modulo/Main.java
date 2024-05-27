package Modulo;

import java.io.IOException;
import java.util.Scanner;
import Modulo.Cines.Cines;
import Modulo.Peliculas.PeliculaMain;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {

        /*
         * Nota para el equipo: Las obserbaciones con notacion "NOTA_Propia" son 
         * observaciones propias fuera de mi conclusion final y que no deberian ser
         * tomadas a muy en cuanta para hacer su evaluacion.Esto por ser superficiales
         * y pueden no ser correctas. Pueden usarlas para sacar mejores conclusiones,
         * Aun asi hacer el favor de analizar el codigo y sacar conclusiones propias.
         * O almenos parafafrasear los textos, debido a que ya lo use en mi evaluacion.
         */

        // Implementacion de CINES
        Cines cines = new Cines();
        PeliculaMain peliculas = new PeliculaMain();
        Scanner sc = new Scanner(System.in);
        int opcion;

        /* 
         * NOTA_Propia: Parece que por la naturaleza del codigo CINES es al ser statica solo
         * permitira almacenar la informacion dentro de la clase, pero al salir 
         * de la misma la informacion se perderá (no comprobado).
         * 
         * Debido a que la clase no tiene atributos propios de la clase, si no, que
         * el metodo mostrarMenu() es el que se encarga de realizar las operaciones
         * y de crear las instancias de las clases necesarias para su funcionamiento,
         * por lo tanto, el ciclo de vida de las mismas, se limita al ciclo de vida del
         * metodo.
         * 
        */


        do{
          System.out.println("MENU");
          System.out.println("[1] Administracion de Cines");
          System.out.println("[2] Administracion de Peliculas");
          System.out.println("[3] Administracion de Dulceria");
          System.out.println("[4] Salir");
          opcion = sc.nextInt();
          switch(opcion){
              case 1:
                System.out.println("MENU----->Cines");
                cines.mostrarMenu();
              break;
              case 2:
                /*
                 * NOTA_Propia: La clase Metodos_principal no encuentra los archivos despues de guardarlos
                 * debudo a que no se establece una ruta absoluta para la lectura y escritura de los archivos.
                 * 
                 * Dicha ruta absoluta deberia debe ser debe contener la direccion del paquete o proyecto
                 * como com/myapp/.../archivo.txt, ademas de que se debe terner en cuenta el sistema operativo
                 * en el que se esta trabajando, ya que la ruta puede variar entere / y \.
                 */
                System.out.println("MENU----->Peliculas");
                peliculas.mostrarMenu2();
              break;
              case 3:
                System.out.println("Dulceria");
                // Implemntacion de Dulceria

                /* Nota para el equipo: No se implemento la clase Dulceria, por lo que no se puede evaluar
                 * No se implemntó debido a errores con el manejo de paquetes, no se pudo importar.
                 */

              break;
              case 4:
                System.out.println("Saliendo...");
              default:
                System.out.println("Introduzca una opcion valida");
              break;
          }
          
        }while(opcion != 4);
        sc.close();
    }
}
