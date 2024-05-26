/**
 *
 * @author Gael
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    public static void Hola(){
        System.out.println("Bienvenido al sistema de control de dulces de: ");
        System.out.println(" ____        _               _         _____ _  __             \r\n" + //
                        "|  _ \\ _   _| | ___ ___ _ __(_) __ _  |_   _(_)/ _| ___  _ __  \r\n" + //
                        "| | | | | | | |/ __/ _ \\ '__| |/ _` |   | | | | |_ / _ \\| '_ \\ \r\n" + //
                        "| |_| | |_| | | (_|  __/ |  | | (_| |   | | | |  _| (_) | | | |\r\n" + //
                        "|____/ \\__,_|_|\\___\\___|_|  |_|\\__,_|   |_| |_|_|  \\___/|_| |_|");
    }

    public static void cargando() throws InterruptedException{
        String[] loadingSymbols = {".", "..", "..."};

        for (int i = 0; i < 10; i++) {
            System.out.print("Loading");
            for (String symbol : loadingSymbols) {
                System.out.print(symbol);
                Thread.sleep(500); // Espera medio segundo
                System.out.print("\b" + " "); // Borra el símbolo anterior
            }
            System.out.print("\r"); // Regresa al inicio de la línea
        }
        System.out.println("\nDone!");
    }

    public static void Adios(){
        System.out.println(" _   _           _                                _          _ _ \r\n" + //
                                                "| | | | __ _ ___| |_ __ _   _ __  _ __ ___  _ __ | |_ ___   | | |\r\n" + //
                                                "| |_| |/ _` / __| __/ _` | | '_ \\| '__/ _ \\| '_ \\| __/ _ \\  | | |\r\n" + //
                                                "|  _  | (_| \\__ \\ || (_| | | |_) | | | (_) | | | | || (_) | |_|_|\r\n" + //
                                                "|_| |_|\\__,_|___/\\__\\__,_| | .__/|_|  \\___/|_| |_|\\__\\___/  (_|_)\r\n" + //
                                                "                           |_|                                   ");
    }
    // Método para mostrar bonito FUENTE DEL CODIGO: STACKOVERFLOW
    public static void MENU() {
        clear();
        String titulo = "BIENVENIDO A LA DULCERIA TIFON";
        String opcion1 = "1.- Dar de alta un producto";
        String opcion3 = "2.- Cambiar precio de un producto";
        String opcion4 = "3.- Mostrar todos los productos";
        String opcion0 = "7.- Salir y guardar";

        // Calcular la longitud máxima de las líneas para establecer el ancho del cuadro
        int maxLength = Math.max(Math.max(Math.max(titulo.length(), opcion1.length()), opcion3.length()), Math.max(opcion4.length(), opcion0.length()));

        // Construir el cuadro
        StringBuilder cuadro = new StringBuilder();
        cuadro.append("┌");
        cuadro.append("─".repeat(maxLength + 2));
        cuadro.append("┐\n");

        // Líneas con contenido
        cuadro.append("│ ").append(padRight(titulo, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(opcion1, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(opcion3, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(opcion4, maxLength)).append(" │\n");
        cuadro.append("│ ").append(padRight(opcion0, maxLength)).append(" │\n");

        // Línea inferior del cuadro
        cuadro.append("└");
        cuadro.append("─".repeat(maxLength + 2));
        cuadro.append("┘");

        System.out.println(cuadro.toString());
    }
    private static String padRight(String s, int length) {
        return String.format("%-" + length + "s", s);
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static Scanner pause = new Scanner(System.in);
    public static void pause() {
        System.out.print("Presiona Enter para continuar...");
        pause.nextLine();
    }

    public static void nuevoproducto(ArrayList<Dulce> Dulces, ArrayList<Tipo> Tipos, ArrayList<Tipo> Tam,
            ArrayList<Tipo> Sab) {
        Metodos.clear();
        //Verificar que no haya dulces duplicados


        Dulce dulcetemp = new Dulce();
        MetodosDulces.IngresarNombre(dulcetemp);
        MetodosDulces.IngresarPrecio(dulcetemp);
        MetodosDulces.ingresarTamaño(dulcetemp, Tam);
        MetodosDulces.ingresarTipo(dulcetemp, Tipos);
        MetodosDulces.ingresarSabor(dulcetemp, Sab);
        MetodosDulces.Cantidad(Dulces, dulcetemp);
        MetodosDulces.generarSKU(dulcetemp);

    }

    public static boolean DulcesVacios(ArrayList<Dulce> Dulces) {
        if (Dulces.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static int Inicio(String mensaje) {
        Scanner sc = new Scanner(System.in);
        String aux;
        boolean valido;
        do {
            MENU();
            System.out.print(mensaje);
            aux = sc.nextLine();
            valido = Numerovalido(aux);
            if (!valido) {
                clear();
                System.out.println("El dato ingresado no es un número entero.");
                pause();
                clear();

            }
        } while (!valido);

        return Integer.parseInt(aux);
    }

    public static boolean Numerovalido(String aux) {
        return aux.matches("[0-9]+") ? true : false; // Si es un numero regresa true, si no regresa false
    }


    }
