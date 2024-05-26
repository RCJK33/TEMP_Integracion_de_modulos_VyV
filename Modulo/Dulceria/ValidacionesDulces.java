/**
 *
 * @author Gael
 */
import java.util.Scanner;
public class ValidacionesDulces {
public static String leer() {
        Scanner sc = new Scanner(System.in);
        String dato;
        boolean valido;
        do {
            Metodos.clear();
            System.out.println("Ingrese el nombre del producto");
            dato = sc.nextLine().trim();
            // Validación del nombre
            valido = dato.matches("[A-Za-z ]+");
            if (!valido) {
                Metodos.clear();
                System.out.println("Ingrese un nombre válido para el producto.\nEl valor debe ser solo letras\nEJEPMLO: Chocolates Con Relleno\n");
                Metodos.pause();
            }else{
                Metodos.clear();
                System.out.println("Nombre registrado correctamente");
                Metodos.pause();
            }
        } while (!valido);

        return dato;
    }

    public static double leerPrecio() {
        Scanner sc = new Scanner(System.in);
        String dato;
        boolean valido;
        do {
            Metodos.clear();
            System.out.println("Ingrese el precio del producto");
            dato = sc.nextLine().trim();
            // Validación del precio
            valido = dato.matches("[0-9]+([.][0-9]+)?");
            if (!valido ) {
                Metodos.clear();
                System.out.println("Ingrese un precio válido para el producto.\nEl valor debe ser según el peso mexicano en formato entero o decimal [ENTERO ( . ) DECIMAS]\nEJEMPLO: 10.50\n");
                Metodos.pause();
            }else{
                Metodos.clear();
                dato = String.format("%.2f", Double.parseDouble(dato));
                System.out.println("Precio registrado correctamente");
                Metodos.pause();
                Metodos.clear();

            }
        } while (!valido);
        //Regresar como double redondeado a 2 decimales
        return Double.parseDouble(dato);
    }

}
