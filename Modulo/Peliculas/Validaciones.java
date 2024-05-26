
package Modulo.Peliculas;

public class Validaciones {

    public static boolean strvacio(String dato) {
        return dato.isEmpty(); // Verifica si la cadena está vacía
    }

    public static boolean soloStr(String dato) {
        return dato.matches("[a-zA-Z ]+"); // Verifica si solo contiene letras o espacios
    }

    public static boolean strYnum(String dato) {
        return dato.matches("[a-zA-Z0-9 ]+"); // Verifica si solo contiene letras o espacios
    }

    public static boolean solonums(String dato) {
        return dato.matches("[0-9]+"); // Verifica si solo contiene dígitos numéricos
    }

    public static boolean comienzaConNumero(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char primerChar = str.charAt(0);

        return Character.isDigit(primerChar);
    }

    public static String primeraMayus(String dato){
        dato = dato.toLowerCase();
        if (dato.length() > 0) {
            dato = Character.toUpperCase(dato.charAt(0)) + dato.substring(1);
        }
        else{
            dato = dato.toUpperCase();
        }
        return dato;
    }

}
