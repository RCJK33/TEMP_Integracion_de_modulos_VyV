package Modulo.Peliculas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Clase que contiene métodos relacionados con las operaciones principales del programa
public class Metodos_principal {

    // Instancia de la clase Validar_Pelicula para validar entradas de datos
    Validar_Pelicula validaPeli = new Validar_Pelicula();

    // Método para mostrar el menú principal del programa
    public void Menu() {
        System.out.println("MENU");
        System.out.println("[1] Leer Archivo de Peliculas");
        System.out.println("[2] Ingresar Pelicula");
        System.out.println("[3] Mostrar Catalogo de Peliculas");
        System.out.println("[4] Eliminar Peliculas");
        System.out.println("[5] Guardar Peliculas en Archivo");
        System.err.println("-------------------------------------");
        System.out.println("[6] Leer categorias de archivo");
        System.out.println("[7] Ingresar nueva Categoria");
        System.out.println("[8] Guardar Categorias en Archivo");
        System.out.println("[9] Salir");
    }

    // Método para cargar películas desde un archivo CSV
    public void cargarPeliculasArchivo(BufferedReader br, Peliculas pelis, ArrayList<Peliculas> peliculas,
            Categorias categoria, ArrayList<Categorias> categorias) {
        String ArchivoCSV = "catalogo_peliculas.csv";
        try {
            br = new BufferedReader(new FileReader(ArchivoCSV));
            String linea = br.readLine();

            while (linea != null) {
                String[] datos = linea.split(",");
                linea = br.readLine();

                pelis = new Peliculas(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim());
                categoria = new Categorias(datos[3].trim());
                categorias.add(categoria);
                peliculas.add(pelis);
            }
            if(!vacioPeliculas(peliculas)){
                System.out.println("\nCargadas Correctamente\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para agregar una nueva película a la lista
    public void agregarPelicula(String nombre, String duracion, String clasificacion, String categoria,
            Peliculas pelis, ArrayList<Peliculas> peliculas) {
        pelis = new Peliculas(nombre, duracion, clasificacion, categoria);
        peliculas.add(pelis);
    }

    // Método para mostrar el catálogo de películas
    public void mostrarCatalogo(ArrayList<Peliculas> peliculas) {
        for (int x = 0; x < peliculas.size(); x++) {
            System.out.println(peliculas.get(x).toString());
        }
    }

    // Método para eliminar una película de la lista
    public boolean eliminarPelicula(ArrayList<Peliculas> peliculas) {
        System.out.println("Ingresa el Nombre de la Película que deseas eliminar:");
        String nombreEliminar = validaPeli.validaNombre();
        for (int x = 0; x < peliculas.size(); x++) {
            if (peliculas.get(x).getNombre().equals(nombreEliminar)) {
                peliculas.remove(x);
                System.out.println("\nSe eliminó correctamente.\n");
                return true;
            }
        }
        return false;
    }

    // Método para guardar las películas en un archivo CSV
    public void guardarPeliculas(ArrayList<Peliculas> peliculas) {
        try (FileWriter fw = new FileWriter("catalogo_peliculas.csv")) {
            for (int x = 0; x < peliculas.size(); x++) {
                String linea = peliculas.get(x).toString2();
                fw.write(linea + "\n");
            }
            System.out.println("\nGuardado Correctamente\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar categorías desde un archivo CSV
    public void cargarCategoriasArchivo(BufferedReader br, Categorias categoria, ArrayList<Categorias> categorias) {
        String ArchivoCSV = "categorias.csv";
        try {
            br = new BufferedReader(new FileReader(ArchivoCSV));
            String linea = br.readLine();

            while (linea != null) {
                String datos = linea;
                linea = br.readLine();

                categoria = new Categorias(datos.trim());
                categorias.add(categoria);
            }
            if(!vacioCategoria(categorias)){
                System.out.println("\nCargadas Correctamente\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para agregar una nueva categoría a la lista
    public void agregarCategoria(String nombre, Categorias catego, ArrayList<Categorias> categorias) {
        catego = new Categorias(nombre);
        categorias.add(catego);
    }

    // Método para eliminar categorías duplicadas de la lista
    public void eliminarCategoriasDupli(ArrayList<Categorias> categorias) {
        for (int i = 0; i < categorias.size(); i++) {
            String categoriaActual = categorias.get(i).getNombre().toLowerCase();
            for (int j = i + 1; j < categorias.size(); j++) {
                String categoriaSiguiente = categorias.get(j).getNombre().toLowerCase();
                if (categoriaActual.equals(categoriaSiguiente)) {
                    categorias.remove(j);
                    j--;
                }
            }
        }
    }

    // Método para mostrar la lista de categorías
    public void mostrarCategorias(ArrayList<Categorias> categorias) {
        System.out.println("\nCATEGORIAS");
        eliminarCategoriasDupli(categorias);
        // Imprimir las categorías sin duplicados
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println("[" + i + "] " + categorias.get(i).getNombre());
        }
    }    

    // Método para seleccionar una categoría
    public String seleccionarCategoria(String opcion, ArrayList <Categorias> categorias){
        // cicla todo el arrayLista e imprime el contenido de cada una de estas
        for (int x = 0; x < categorias.size(); x++) {
            if(Integer.parseInt(opcion) == (x)){
                return categorias.get(x).getNombre();
            }
        }
        if(Integer.parseInt(opcion) == 100){
            return "nuevo";
        }
        return null;
    }

    // Método para guardar las categorías en un archivo CSV
    public void guardarCategorias(ArrayList<Categorias> categorias) {
        try (FileWriter fw = new FileWriter("categorias.csv")) {
            for (int x = 0; x < categorias.size(); x++) {
                String linea = categorias.get(x).getNombre();
                fw.write(linea + "\n");
            }
            if(!vacioCategoria(categorias)){
                System.out.println("\nGuardadas Correctamente\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar si la lista de películas está vacía
    public boolean vacioPeliculas(ArrayList<Peliculas> peliculas) {
        if (peliculas.isEmpty()) {
            System.out.println("\nNo hay Catalogo de Peliculas.\n");
            return true;
        }
        return false;
    }

    // Método para verificar si la lista de categorías está vacía
    public boolean vacioCategoria(ArrayList<Categorias> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("\nNo hay Categorias existentes.\n");
            return true;
        }
        return false;
    }
}
