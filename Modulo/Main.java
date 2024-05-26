package Modulo;

import java.io.IOException;
import java.util.Scanner;
import Modulo.Cines.Cines;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {

        // Implementacion de CINES
        Cines cines = new Cines();
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("[1] Administracion de Cines");
        opcion = sc.nextInt();



        do{
          switch(opcion){
              case 1:
                cines.mostrarMenu();
              break;
              case 2:

              break;
              case 3:

              break;
              default:
              System.out.println("Introduzca una opcion valida");
              break;
          }


      }while(!salir);


        //Implementacion de Peliculas

        // Implementacion de Dulceria

    }
}
