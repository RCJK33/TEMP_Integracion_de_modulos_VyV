/**
 *
 * @author Gael
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dulceria {
    public static ArrayList<Tipo> Tipos = new ArrayList<Tipo>();
    public static ArrayList<Tipo> Tam = new ArrayList<Tipo>();
    public static ArrayList<Dulce> Dulces = new ArrayList<Dulce>();
    public static ArrayList<Tipo> Sab = new ArrayList<Tipo>();

    // METODO PARA CARGAR LOS TIPOS DE DULCES (TAMAÑO, SABOR Y TIPO) 🠟🠟
    public static void CargarTamaño() {
        try {
            File archivo = new File(
                    "D:\\\\UABC\\\\Sexto semestre\\\\Verificacion y validacion de software\\\\ExamenPDD\\\\Tipo\\\\TiposDulces.csv");
            Scanner scanner = new Scanner(archivo);

            // Leer cada línea del archivo CSV
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                Tipo Ta = new Tipo(partes[1].trim());
                Tam.add(Ta);
                Tipo Tb = new Tipo(partes[2].trim());
                Sab.add(Tb);
                Tipo Tipo = new Tipo(partes[0].trim());
                Tipos.add(Tipo);

            }
            scanner.close(); // Cerrar el scanner
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }

    // METODO PARA CREAR EL ARCHIVO CSV 🠟🠟
    public static void crearArchivoCSV() { // Este metodo crea el archivo CSV si no existe
        try {
            File archivo = new File(
                    "D:\\UABC\\Sexto semestre\\Verificacion y validacion de software\\ExamenPDD\\Dulces.csv");
            if (archivo.createNewFile()) {
                Metodos.clear();
                System.out.println("Es la primera vez que se ejecuta el programa.\nEs necesario crear un archivo CSV para guardar los datos.");
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
    // METODO PARA CARGAR LOS DULCES DEL ARCHIVO CSV 🠟🠟
    @SuppressWarnings("resource") // Suprimir advertencias de recursos no cerrados en el scanner
    public static void Dulcesentock(ArrayList<Dulce> Dulces) { // Este metodo carga los dulces del archivo CSV a la
                                                               // lista de dulces
    //Si ya se cargaron los dulces, no se cargan de nuevo
        if (!Dulces.isEmpty()) {
            System.out.println("Los dulces ya han sido cargados.");
            Metodos.pause();
            return;
            }

        try {
            File archivo = new File( // Verificar la ruta del archivo CSV
                    "D:\\\\UABC\\\\Sexto semestre\\\\Verificacion y validacion de software\\\\ExamenPDD\\\\Dulces.csv"); // Ruta del archivo CSV
            Scanner scanner = new Scanner(archivo);
            if (!scanner.hasNextLine()) { // Verificar si el archivo CSV está vacío
                System.out.println("BUSCANDO DATOS...");
                //Esperar 1 segundo
                try {
                    Thread.sleep(1000);
                    System.out.println("No hay datos en el archivo.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Metodos.pause();
                return;

            }

            // Leer desde la segunda línea del archivo CSV
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                Dulce dulce = new Dulce();
                dulce.setNombre(partes[0].trim());
                dulce.setPrecio(Double.parseDouble(partes[1].trim()));
                Tipo tipo = new Tipo(partes[2].trim());
                Tipo sa = new Tipo(partes[3].trim());
                Tipo se = new Tipo(partes[4].trim());
                dulce.settipodulce(tipo);
                dulce.se(se);
                dulce.sa(sa);
                dulce.setCantidad(Integer.parseInt(partes[5].trim()));
                dulce.setSKU(partes[6].trim());
                Dulces.add(dulce);
            }
            scanner.close(); // Cerrar el scanner
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }

    // METODO PARA GUARDAR LOS DULCES EN EL ARCHIVO CSV CADA VEZ QUE SE GUARDE,
    // PRIORIZANDO LOS DATOS YA EXISTENTES 🠟🠟
    public static void guardarCSV(ArrayList<Dulce> Dulces) {
        //Antes de guardar, se eliminan los datos anteriores del archivo
        try {
            FileWriter archivo = new FileWriter(
                    "D:\\\\UABC\\\\Sexto semestre\\\\Verificacion y validacion de software\\\\ExamenPDD\\\\Dulces.csv");
            BufferedWriter escritor = new BufferedWriter(archivo);
            escritor.write(""); // Limpiar el archivo
            escritor.close(); // Cerrar el escritor
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
        //Guardar los datos actuales
        try {
            FileWriter archivo = new FileWriter(
                    "D:\\\\UABC\\\\Sexto semestre\\\\Verificacion y validacion de software\\\\ExamenPDD\\\\Dulces.csv");
            BufferedWriter escritor = new BufferedWriter(archivo);
            // Escribir los encabezados
            escritor.write("[ Nombre ],[ Precio ],[ Tipo ],[ Sabor ],[ Tamaño ],[ Cantidad ],[ SKU ]\n");

            // Escribir cada dulce en el archivo CSV
            for (Dulce dulce : Dulces) {
                escritor.write(String.format("%s,%s,%s,%s,%s,%s,%s\n", // Formato de la línea del archivo CSV con los
                                                                        // datos del dulce
                        dulce.getNombre(), dulce.getPrecio(), dulce.getse(), dulce.gettipodulce(), dulce.getsa(), dulce.getCantidad(), dulce.getSKU()));
            }
            System.out.println("Guardando datos...");
            //Esperar 1 segundo
            try {
                Thread.sleep(1000);
                System.out.println("Datos guardados.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            escritor.close(); // Cerrar el escritor
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CargarTamaño();
        int opc = 0;
        //Cargo los dulces del archivo CSV al iniciar el programa


        crearArchivoCSV();
        Dulcesentock(Dulces);
        Metodos.clear();
        Metodos.Hola();


        Metodos.pause();
        do {
            do {
                opc = Metodos.Inicio("Seleccione una opción: ");
            } while (opc < 0 || opc > 7);
            switch (opc) {
                case 1:
                    Metodos.clear();
                    Metodos.nuevoproducto(Dulces, Tipos, Tam, Sab);
                    break;
                case 2: // Cambiar precio
                    Metodos.clear();
                    MetodosDulces.CambioPrecio(Dulces, Tipos, Tam, Sab);
                    break;
                case 3:// Mostrar todos los dulces
                    Metodos.clear();
                    MetodosDulces.MostrarDulces(Dulces);
                    break;
                case 7: // Salir y guardar
                    Metodos.clear();
                    guardarCSV(Dulces);
                    Metodos.Adios();

                    Metodos.pause();
                    break;
                default:
                    Metodos.clear();
                    System.out.println("Opción no válida.");
                    Metodos.pause();
                    break;
            }
        } while (opc != 7); // Se detiene el programa cuando el usuario selecciona la opcion 7

    }
}
