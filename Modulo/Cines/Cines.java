//Lozano Hernandez Joel
//Examen 2 Paradigmas. Modulo 1: Sucursales y Salas.
//clase principal

package Modulo.Cines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cines {
    public static void mostrarMenu() throws IOException {
        Scanner lector = new Scanner(System.in);
        Metodos metodos = new Metodos(); //creamos una variable metodos para poder llamar los metodos
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        ArrayList<Sala> salas = new ArrayList<>();
        int opcion = 0;
        boolean salir = false;

        do{
            metodos.menu();
            opcion = Integer.parseInt(lector.nextLine());
            switch(opcion){
                case 1:
                sucursales.add(metodos.altaSuc());
                int num = sucursales.size();
                sucursales.get(num-1).setNum(num);
                break;
                case 2:
                salas.add(metodos.altaSala(sucursales));
                num = salas.size();
                break;
                case 3:
                metodos.mostrarSalasPorSucursal(sucursales);
                break;
                case 4:
                System.out.println("Ingrese el codigo de la sala que desea eliminar: ");
                String codigoSala = lector.nextLine();
                metodos.eliminarSala(sucursales, codigoSala);
                break;
                case 5:
                metodos.sucFueradeServ(sucursales);
                break;
                case 6:
                metodos.salaFueraDeServ(sucursales);
                break;
                case 7:
                metodos.guardarArchivo(sucursales);
                break;
                case 8:
                salir = true;
                break;
                default:
                System.out.println("Introduzca una opcion valida");
                break;
            }


        }while(!salir);

    }

}
