/**
 *
 * @author Gael
 */
import java.util.Scanner;
import java.util.ArrayList;

public class MetodosDulces {
    public static void generarSKU(Dulce dulcetemp) {
        String nombre = dulcetemp.getNombre().toUpperCase();
        String precio = String.valueOf(dulcetemp.getPrecio());
        try{
            precio = precio.substring(0, precio.indexOf("."));
            if (nombre.length() > 3) {
                nombre = nombre.substring(0, 3);
                String SKU = nombre + precio;
                dulcetemp.setSKU(SKU);
            }else if(nombre.length() <3){
                nombre = nombre.substring(0, 1);
                String SKU = nombre + precio;
                dulcetemp.setSKU(SKU);
            }
        }catch(Exception e){
            System.out.println("Error al generar el SKU del producto: " + e.getMessage());
        }
    }
    public static void ingresarTamaño(Dulce dulcetemp, ArrayList<Tipo> Tam) {
        Scanner sc = new Scanner(System.in);
        int tam = 0;
        do {
            Metodos.clear();
            System.out.println("Ingrese el tamaño del producto:");
            for (int i = 0; i < Tam.size(); i++) {
                System.out.println((i + 1) + ". " + Tam.get(i));
            }
            System.out.print("Seleccione el número correspondiente al tamaño: ");
            String dato = sc.nextLine().trim();
            // Validación de entrada
            if (!dato.matches("[0-9]+")) {
                Metodos.clear();
                System.out.println("Ingrese una opción válida para el producto. El valor debe ser un número entero.");
                Metodos.pause();
                continue; // Reiniciar el ciclo con el continue se salta el código restante
            }
            tam = Integer.parseInt(dato);
            if (tam < 1 || tam > Tam.size()) {
                Metodos.clear();
                System.out.println(
                        "Ingrese una opción válida para el producto. El valor debe estar dentro del rango disponible.");
                Metodos.pause();
            }
        } while (tam < 1 || tam > Tam.size());


        dulcetemp.se(Tam.get(tam - 1));
        Metodos.clear();
        System.out.println("Tamaño registrado correctamente");
        Metodos.pause();
        Metodos.clear();
    }

    public static void ingresarSabor(Dulce dulcetemp, ArrayList<Tipo> Sab) {
        Scanner sc = new Scanner(System.in);
        int sabor = 0;
        do {
            Metodos.clear();
            System.out.println("Ingrese el sabor del producto:");
            for (int i = 0; i < Sab.size(); i++) {
                System.out.println((i + 1) + ". " + Sab.get(i));
            }
            System.out.print("Seleccione el número correspondiente al sabor: ");
            String dato = sc.nextLine().trim();
            // Validación de entrada
            if (!dato.matches("[0-9]+")) {
                Metodos.clear();
                System.out.println("Ingrese una opción válida para el sabor. El valor debe ser un número entero.");
                Metodos.pause();
                continue; // Reiniciar el ciclo con el continue se salta el código restante
            }
            sabor = Integer.parseInt(dato);
            if (sabor < 1 || sabor > Sab.size()) {
                Metodos.clear();
                System.out.println(
                        "Ingrese una opción válida para el sabor. El valor debe estar dentro del rango disponible.");
                Metodos.pause();
            }
        } while (sabor < 1 || sabor > Sab.size());


        dulcetemp.sa(Sab.get(sabor - 1));
        Metodos.clear();
        System.out.println("Sabor registrado correctamente");
        Metodos.pause();
        Metodos.clear();
    }

    public static void IngresarPrecio(Dulce dulcetemp) {
        try {
            dulcetemp.setPrecio(ValidacionesDulces.leerPrecio());
        } catch (NumberFormatException e) {
            System.out.println("Error: El precio ingresado no es válido. Por favor ingrese un número válido.");
        } catch (Exception e) {
            System.out.println("Error al ingresar el precio del producto: " + e.getMessage());
        }
    }

    public static void IngresarNombre(Dulce dulcetemp) {
        try {
            //Validar que no haya otro dulce con el mismo nombre
            if (Metodos.DulcesVacios(Dulceria.Dulces)) { // Si no hay dulces registrados no se valida
                dulcetemp.setNombre(ValidacionesDulces.leer()); // Se ingresa el nombre del dulce
            } else { // Si hay dulces registrados se valida que no haya otro con el mismo nombre
                boolean valido = false; // Bandera para validar el nombre
                do {  // Ciclo para validar el nombre
                    dulcetemp.setNombre(ValidacionesDulces.leer()); // Se ingresa el nombre del dulce
                    for (Dulce dulce : Dulceria.Dulces) { // Se recorren los dulces registrados
                        if (dulce.getNombre().equalsIgnoreCase(dulcetemp.getNombre())) {  // Si el nombre del dulce a registrar es igual a uno ya registrado
                            Metodos.clear(); // Se limpia la consola
                            System.out.println("Ya existe un producto con ese nombre. Ingrese un nombre diferente.");
                            Metodos.pause(); // Se pausa el programa
                            valido = false;
                            break;
                        } else {
                            valido = true;
                        }
                    }
                } while (!valido);
            }


        } catch (Exception e) {
            System.out.println("Error al ingresar el nombre del producto");
        }
    }

    public static void ingresarTipo(Dulce dulcetemp, ArrayList<Tipo> Tipos) {
        Scanner sc = new Scanner(System.in);
        int tipo = 0;
        do {
            Metodos.clear();
            System.out.println("Ingrese el tipo del producto:");
            for (int i = 0; i < Tipos.size(); i++) {
                System.out.println((i + 1) + ". " + Tipos.get(i));
            }
            System.out.print("Seleccione el número correspondiente al tipo: ");
            String dato = sc.nextLine().trim();
            // Validación de entrada
            if (!dato.matches("[0-9]+")) {
                Metodos.clear();
                System.out.println("Ingrese una opción válida para el tipo. El valor debe ser un número entero.");
                Metodos.pause();
                continue; // Reiniciar el ciclo con el continue se salta el código restante
            }
            tipo = Integer.parseInt(dato);
            if (tipo < 1 || tipo > Tipos.size()) {
                Metodos.clear();
                System.out.println(
                        "Ingrese una opción válida para el tipo. El valor debe estar dentro del rango disponible.");
                Metodos.pause();
            }
        } while (tipo < 1 || tipo > Tipos.size());


        dulcetemp.settipodulce(Tipos.get(tipo - 1));
        Metodos.clear();
        System.out.println("Tipo registrado correctamente");
        Metodos.pause();
        Metodos.clear();
    }

    public static void CambioPrecio(ArrayList<Dulce> Dulces, ArrayList<Tipo> Tipos, ArrayList<Tipo> Tam,
            ArrayList<Tipo> Sab) {
        Scanner sc = new Scanner(System.in);
        if (Metodos.DulcesVacios(Dulces)) {
            Metodos.clear();
            System.out.println("No hay productos registrados para cambiar el precio.");
            Metodos.pause();
        } else {
            Metodos.clear();
            boolean valido = false;
            do {
                Metodos.clear();
                System.out.println("Seleccione el producto al que desea cambiar el precio:");
                // Se mostrarán los productos disponibles
                for (int i = 0; i < Dulces.size(); i++) {
                    System.out.println((i + 1) + ". " + "\n" + Dulces.get(i));
                }
                int producto = 0;
                String aux;
                // Validación de entrada
                System.out.print("Seleccione el número correspondiente al producto: ");
                System.out.println("\nSi desea regresar al menú principal, presione 0");
                aux = sc.nextLine();
                if (!aux.matches("[0-9]+")) {
                    Metodos.clear();
                    System.out.println("El dato ingresado no es un número entero.");
                    Metodos.pause();
                    Metodos.clear();
                } else if (aux.equals("0")) {
                    return;
                } else {
                    producto = Integer.parseInt(aux);
                    if (producto < 1 || producto > Dulces.size()) {
                        Metodos.clear();
                        System.out.println(
                                "Ingrese una opción válida para el producto. El valor debe estar dentro del rango disponible.");
                        Metodos.pause();
                    } else {
                        Metodos.clear();
                        System.out.println("Ingrese el nuevo precio del producto:");
                        Metodos.pause();
                        double precio = ValidacionesDulces.leerPrecio();
                        Dulces.get(producto - 1).setPrecio(precio);
                        System.out.println("Precio actualizado correctamente");
                        Metodos.pause();
                        Metodos.clear();
                        valido = true;
                    }
                }


            } while (!valido);
        }
    }

    public static void Cantidad(ArrayList<Dulce> Dulces, Dulce dulcetemp) {
        Scanner sc = new Scanner(System.in);
        try {
            int qty = 0;
            do {
                Metodos.clear();
                System.out.println("Ingrese la cantidad de productos:");
                String dato = sc.nextLine().trim();
                // Validación de entrada
                if (!dato.matches("[0-9]+")) {
                    Metodos.clear();
                    System.out.println(
                            "Ingrese una cantidad válida para el producto. El valor debe ser un número entero.");
                    Metodos.pause();
                    continue; // Reiniciar el ciclo con el continue se salta el código restante
                }
                qty = Integer.parseInt(dato);

                dulcetemp.setCantidad(qty);
                Dulces.add(dulcetemp);
            } while (qty < 1); // Validar que la cantidad sea mayor a 0


        } catch (NumberFormatException e) {
            System.out.println("Error al ingresar la cantidad de productos. Debe ser un número entero.");
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }

    public static void MostrarDulces(ArrayList<Dulce> Dulces) {
        Metodos.clear();
        if (Metodos.DulcesVacios(Dulces)) {
            System.out.println("No hay productos registrados.");
            Metodos.pause();
            return;
        }else{
            System.out.println("Productos registrados:");
            for (Dulce dulce : Dulces) {
                System.out.println(dulce);
            }
        }



        Metodos.pause();
        Metodos.clear();
    }
}
