/*Lopez Galicia Luis Angel
 * Modulo 2: Peliculas y Categorias
*/

package Modulo.Peliculas; // Update the package declaration to match the expected package

/*Lopez Galicia Luis Angel
 * Modulo 2: Peliculas y Categorias
*/

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;


public class PeliculaMain {

    public static void mostrarMenu2(){
        // Inicialización de variables y estructuras de datos
        Scanner ptr = new Scanner(System.in);
        ArrayList<Peliculas> peliculas = new ArrayList<>();
        ArrayList<Categorias> categorias = new ArrayList<>();
        Peliculas pelis = null;
        Categorias catego = null;
        Metodos_principal metodo = new Metodos_principal();
        Validar_Pelicula validaPeli = new Validar_Pelicula();
        BufferedReader br = null;
        String nombre, duracion, clasificacion, categoria, opcion;

        do {
            // Se muestra un mensaje y un menú
            System.out.println("Nota: Asegúrece de GUARDAR los datos ANTES de LEER nuevamente los ARCHIVOS ");
            metodo.Menu();

            // Se valida y procesa la opción seleccionada
            opcion = validaPeli.validaOpcion();
            switch (Integer.parseInt(opcion)) {
                case 1:
                    // Opción para cargar películas desde archivo
                    peliculas.clear();
                    metodo.cargarPeliculasArchivo(br, pelis, peliculas, catego, categorias);
                    break;
                case 2:
                    // Opción para agregar una nueva película
                    nombre = validaPeli.validaNombre();
                    duracion = validaPeli.validaDuracion();
                    clasificacion = validaPeli.validaClasificacion();

                    if (categorias.isEmpty()) {
                        // Si no hay categorías, se solicita agregar una nueva
                        System.out.println("No hay categorias existentes.");
                        System.out.println("Ingrese la Categoria a la que corresponda. ");
                        categoria = validaPeli.validaCategoria();
                        metodo.agregarCategoria(categoria, catego, categorias);
                    } else {
                        // Si hay categorías, se muestra y se permite seleccionar una
                        do {
                            metodo.mostrarCategorias(categorias);
                            System.out.println("[100] Para agregar nueva categoria");
                            opcion = validaPeli.validaOpcion();
                        } while (metodo.seleccionarCategoria(opcion, categorias) == null);

                        // Si se selecciona la opción de agregar nueva categoría, se solicita y se agrega
                        if (Integer.parseInt(opcion) == 100){
                            categoria = validaPeli.validaCategoria();
                            metodo.agregarCategoria(categoria, catego, categorias);

                            // Se solicita nuevamente seleccionar una categoría después de agregarla
                            do{
                                metodo.mostrarCategorias(categorias);
                                System.out.println("\nEliga una Categoria");
                                opcion = validaPeli.validaOpcion();
                            } while (metodo.seleccionarCategoria(opcion, categorias) == null || metodo.seleccionarCategoria(opcion, categorias) == "nuevo");
                        }
                        categoria = metodo.seleccionarCategoria(opcion, categorias);
                    }

                    // Se agrega la película con los datos ingresados
                    metodo.agregarPelicula(nombre, duracion, clasificacion, categoria, pelis, peliculas);
                    System.out.println("\nAgregada Correctamente\n");
                    break;
                case 3:
                    // Opción para mostrar el catálogo de películas
                    if (!metodo.vacioPeliculas(peliculas))
                        System.out.println("");
                        metodo.mostrarCatalogo(peliculas);
                    break;
                case 4:
                    // Opción para eliminar una película
                    if (!metodo.vacioPeliculas(peliculas))
                        if (!metodo.eliminarPelicula(peliculas)) {
                            System.out.println("\nNo encontrada/No existe.\n");
                        }
                    break;
                case 5:
                    // Opción para guardar películas en archivo
                    if (!metodo.vacioPeliculas(peliculas))
                        metodo.guardarPeliculas(peliculas);
                    break;
                case 6:
                    // Opción para cargar categorías desde archivo
                    categorias.clear();
                    metodo.cargarCategoriasArchivo(br, catego, categorias);
                    break;
                case 7:
                    // Opción para agregar una nueva categoría
                    System.out.println("");
                    metodo.mostrarCategorias(categorias);;
                    categoria = validaPeli.validaCategoria();
                    metodo.agregarCategoria(categoria, catego, categorias);
                    metodo.eliminarCategoriasDupli(categorias);
                    System.out.println("\nAgregada Correctamente\n");
                    break;
                case 8:
                    // Opción para eliminar categorías duplicadas y guardarlas en archivo
                    if (!metodo.vacioCategoria(categorias)){
                            metodo.eliminarCategoriasDupli(categorias);
                            metodo.guardarCategorias(categorias);}
                    break;
                case 9:
                    // Opción para salir del programa
                    System.out.println("Gracias por su tiempo");
                    break;
                default:
                    // Mensaje en caso de opción inválida
                    System.out.println("Ingrese una de las opciones superiores.");
                    break;
            }
        } while (Integer.parseInt(opcion) != 9);

        ptr.close();
    }
}
