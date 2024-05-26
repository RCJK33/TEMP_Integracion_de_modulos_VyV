//clase exclusivamente para metodos
//para la mayoria de metodos para manipular los ArrayList y archivos, utilice de apoyo el ejercicio 16 de Paradigmas
package Modulo.Cines;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    //validar un numero entero
    public boolean num(String dato){
        int num = 0;
        try{
            num = Integer.parseInt(dato);
            return true;
        }
        catch(Exception error){
           //System.out.println(error.getMessage());
            return false;
        }
    }

    //muestra el menu de opciones
    public void menu() {

        System.out.println("\nMenu");
        System.out.println("1. Alta de Sucursal");
        System.out.println("2. Agregar Sala");
        System.out.println("3. Mostrar Sucursales y Salas");
        System.out.println("4. Eliminar Sala");
        System.out.println("5. Inhabilitar Sucursal (poner fuera de servicio)");
        System.out.println("6. Inhabilitar Sala (poner fuera de servicio)");
        System.out.println("7. Guardar Archivo");
        System.out.println("8. Salir");

    }

    //dar de alta una sucursal
    public Sucursal altaSuc(){
        Scanner lector = new Scanner(System.in);
        Sucursal temp = new Sucursal(); //creamos una variable temporal tipo objeto de sucursal, para manipular los atributos dentro de esta

        //pedimos al usuario ingresar en pantalla los respectivos atributos de la sucursal
        System.out.println("----Alta Sucursal----");
        System.out.println("Nombre de la Sucursal: ");
        temp.setNombre(lector.nextLine());
        System.out.println("Ubicacion: ");
        temp.setUbicacion(lector.nextLine());
        System.out.println("RFC: ");
        temp.setRfc(lector.nextLine());


        return temp;

    }
    //para agregar una sala
    public Sala altaSala(ArrayList<Sucursal> sucursales){
        Scanner lector = new Scanner(System.in);
        Sala temp = new Sala(); //creamos una variable temporal tipo objeto de sala, para manipular los atributos dentro de esta
        int opc; //variable opcion para manipular los switch case
        int numSuc; //variable numero de sucursal para cuando recorra e imprima las sucursales pueda elegir un numero de la lista mostrada

        if(sucursales==null || sucursales.size()==0){ //si no hay elementos en el ArrayList de sucursales
            System.out.println("\tNo hay sucursales en existencia, se solicita dar de alta al menos una sucursal antes de agregar una sala");
        }
        else{ //en caso de que si encuentre elementos en el ArrayList de sucursales
        System.out.println("----Agregar Sala----");
        System.out.println("¿A que sucursal desea agregar la nueva Sala?: ");

            for(int i =0; i<sucursales.size(); i++){ //recorremos las sucursales con un ciclo for normal, para mostrar una lista de las sucursales con sus atributos
                //en un solo renglon cada una
                System.out.println(" " + (i+1) + ". " + sucursales.get(i));
            }

            boolean numVal = false;
            do{
                numSuc = Integer.parseInt(lector.nextLine());
                if(numSuc<1 || numSuc>sucursales.size()) {
                    System.out.println("Por favor ingrese una opcion valida: ");
                    numVal = false;
                }
                else{
                    numVal = true;
                }

            }while(numVal==false);

            temp.setSucursal(sucursales.get(numSuc-1)); //aqui asignamos la sala en la respectiva sucursal seleccionada anteriormente

        System.out.println("Codigo de Sala: ");
        String codigoSala; //creamos una variable codigoSala que le pediremos al usuario para poder validarla
        boolean codigoValido = false; //creamos una variable booleana para indicar si el codigo es valido (que no se repite)
        do {
            codigoSala = lector.nextLine();
            codigoValido = codigoSalaIgual(sucursales, codigoSala); //a la variable booleana le damos el valor que retorne la funcion que valida si el codigo es igual
            if(codigoValido==false) { //si tenemos un valor falso quiere decir que si se repite el codigo de sala y mandamos un mensaje de error
                System.out.println("¡El código de sala ya existe! Ingrese otro código:");
            }
        }while(!codigoValido); //seguimos pidiendo el codigo de sala al usuario mientras el codigo sea similar a uno ya existente
        temp.setCodigo(codigoSala);

        System.out.println("Tamano de la Sala: ");
            System.out.println("\t1. Grande (400 Asientos en sala)");
            System.out.println("\t2. Mediana (200 Asientos en sala)");
            System.out.println("\t3. Chica (100 Asientos en sala)");
            System.out.println("Elige una de las opciones: ");
            opc = Integer.parseInt(lector.nextLine());
            switch(opc){
                case 1:
                temp.setTamano("Grande");
                temp.setNumasientos("400");
                break;
                case 2:
                temp.setTamano("Mediana");
                temp.setNumasientos("200");
                break;
                case 3:
                temp.setTamano("Chica");
                temp.setNumasientos("100");
                break;
                default:
                temp.setTamano("Mediana");
                temp.setNumasientos("200");
                break;
            }
        System.out.println("Tipo de Sala: ");
            System.out.println("\t1. Sala Normal");
            System.out.println("\t2. Sala Funcion 3D");
            System.out.println("\t3. Sala Funcion 4D");
            System.out.println("\t4. Sala Con Megapantalla");
            System.out.println("Elige una de las opciones: ");
            opc = Integer.parseInt(lector.nextLine());
            switch(opc){
                case 1:
                temp.setTiposala("Normal");
                break;
                case 2:
                temp.setTiposala("Funcion 3D");
                break;
                case 3:
                temp.setTiposala("Funcion 4D");
                break;
                case 4:
                temp.setTiposala("Megapantalla");
                break;
                default:
                temp.setTiposala("Normal");
                break;
            }

        temp.getSucursal().getSalas().add(temp);//agregamos al ArrayList de las sucursales, la sala anteriormente registrada
        }
        return temp;


    }

    //metodo booleano para validar si ya existe un codigo sala similar al introducido en el ArrayList de salas en sucursales
    public boolean codigoSalaIgual(ArrayList<Sucursal> sucursales, String codigoSala) {
        for (Sucursal sucursal : sucursales) {//recorremos las sucursales
            for (Sala sala : sucursal.getSalas()) { //recorremos las salas dentro de cada sucursal
                if (sala.getCodigo().equals(codigoSala)) { //si el codigo de sala recibido en la funcion, es igual a un codigo sala existente en alguna sala
                    return false; //retornamos verdadero si el codigo sala es igual al de la sala
                }
            }
        }
        return true; //retornamos falso si no se cumple lo anterior
    }

    //para mostrar las salas por sucursales
    public void mostrarSalasPorSucursal(ArrayList<Sucursal> sucursales) {
        if (sucursales == null || sucursales.size()==0) { //en caso de que el ArrayList de sucursales no encuentre ninguna sucursal
            System.out.println("No hay sucursales disponibles.");
        } else {
            // Mostramos las salas para cada sucursal
            for (Sucursal sucursal : sucursales) { //utilizamos un ciclo para recorrer el ArrayList de sucursales
                //mostramos en pantalla los respectivos atributos de cada sucursal
                System.out.println("\nSucursal: " + sucursal.getNombre());
                System.out.println("Ubicación: " + sucursal.getUbicacion());
                System.out.println("RFC: " + sucursal.getRfc());
                System.out.println("Fuera de servicio: " + sucursal.isFueradeserv());
                System.out.println("Salas de la sucursal: ");
                for (Sala sala : sucursal.getSalas()) { //dentro del ciclo anterior, otro ciclo para recorrer el ArrayList de las salas dentro de su respectiva sucursal
                    //mostramos en pantalla los respectivos atributos de cada sala
                    System.out.println("\tCodigo de la sala: " + sala.getCodigo());
                    System.out.println("\tTamano: " + sala.getTamano());
                    System.out.println("\tNumero de asientos: " + sala.getNumasientos());
                    System.out.println("\tTipo: " + sala.getTiposala());
                    System.out.println("\tFuera de servicio: " + sala.isFueradeserv() + "\n");
                }
            }
        }
    }

    //para eliminar una sala con un codigo de sala brindado
    public void eliminarSala(ArrayList<Sucursal> sucursales, String codigoSala){
        boolean salaElim = false; //variable booleana para validar cuando la sala se haya eliminado, inicializa en false

        for(Sucursal sucursal: sucursales){ //recorremos el ArrayList de las sucursales

            for(Sala sala: sucursal.getSalas()){ //recorremos el ArrayList de las salas dentro de las sucursales

                if(sala.getCodigo().equals(codigoSala)){ //si el codigo ingresado es igual al codigo de la sala en existencia
                    sucursal.getSalas().remove(sala); //eliminamos la sala de la sucursal
                    salaElim = true;
                    break; //interrumpimos el bucle una vez eliminada la sala
                }
            }
        }
        if(salaElim==true){ //si se ha eliminado la sala, mostramos un mensaje diciendo que la sala se ha eliminado
            System.out.println("La sala con codigo: " + codigoSala + " ha sido eliminada");
        }
        else{ //si no se elimino la sala, quiere decir que ingresamos un codigo incorrecto o de una sala inexistente e imprimimos un mensaje de error
            System.out.println("No se encontro una sala con el codigo " + codigoSala);
        }

    }

    //para marcar una sucursal fuera de servicio
    public void sucFueradeServ(ArrayList<Sucursal> sucursales){

        Scanner lector = new Scanner(System.in);

        if(sucursales == null || sucursales.size()==0){//si no hay sucursales
            System.out.println("No hay sucursales en existencia para marcar fuera de servicio.");
        }
        else{
            System.out.println("Sucursales disponibles: ");
            for (int i = 0; i < sucursales.size(); i++){ //con este ciclo mostramos las sucursales en existencia
                System.out.println((i+1) + ". " + sucursales.get(i).getNombre());
            }
        System.out.println("Seleccione la sucursal a marcar fuera de servicio:");
        boolean numVal = false;//variable para validar que el numero seleccionado sea valido
        int numSuc;

        do{
            numSuc = Integer.parseInt(lector.nextLine());
            if(numSuc<1 || numSuc>sucursales.size()) {
                System.out.println("Por favor ingrese una opcion valida: ");
                numVal = false;
            }
            else{
                numVal = true;
            }

        }while(numVal==false);//este ciclo se repite mientras el usuario introduzca un numero no valido

            Sucursal sucursalSeleccionada = sucursales.get(numSuc-1); //creamos una variable tipo sucursal en la que asignaremos la sucursal seleccionada
            sucursalSeleccionada.setFueradeserv(true); //a la sucursal seleccionada la asignamos fuera de servicio
            System.out.println("La Sucursal " + sucursalSeleccionada.getNombre() + " ha sido marcada como fuera de servicio");
    }

    }

    public void salaFueraDeServ(ArrayList<Sucursal> sucursales){

        Scanner lector = new Scanner(System.in);

        if (sucursales == null || sucursales.size()==0){ //si no hay sucursales
            System.out.println("No hay sucursales registradas para marcar una sala fuera de servicio.");
        } else {

            System.out.println("Sucursales disponibles: ");
            for (int i=0; i<sucursales.size(); i++) { //con este ciclo mostramos las sucursales disponibles
                Sucursal sucursal = sucursales.get(i);
                System.out.println((i+1) + ". " + sucursal.getNombre());
                System.out.println("  Salas disponibles: ");
                ArrayList<Sala> salas = (ArrayList<Sala>)sucursal.getSalas();
                for (int j=0; j<salas.size(); j++) { //con este ciclo mostramos las salas disponibles para cada sucursal
                    Sala sala = salas.get(j);
                    System.out.println("      " + (j+1) + ". Sala con el codigo: " + sala.getCodigo());
                }
            }


            boolean sucVal = false; //variable booleana que permite saber si el numero de sucursal es valido
            int opcionSucursal;
            System.out.println("Seleccione la sucursal:");
            do{
                opcionSucursal = Integer.parseInt(lector.nextLine());
                if (opcionSucursal<1 || opcionSucursal>sucursales.size()) {
                    System.out.println("Por favor ingrese una opcion valida: ");
                    sucVal = false;
                }
                else{
                    sucVal = true;
                }
            }while(sucVal==false);//este ciclo se repite mientras el usuario introduzca un numero no valido
            Sucursal sucursalSeleccionada = sucursales.get(opcionSucursal-1);

            ArrayList<Sala> salas = (ArrayList<Sala>)sucursalSeleccionada.getSalas();
            if(salas==null || salas.size()==0){
                System.out.println("No hay salas registradas para marcar una sala fuera de servicio. ");
            }
            else{

            System.out.println("Seleccione la sala a marcar fuera de servicio:");
            boolean salVal = false;
            int opcionSala;

            do{
                opcionSala = Integer.parseInt(lector.nextLine());
                if (opcionSala<1 || opcionSala>salas.size()){
                    System.out.println("Por favor ingrese una opcion valida");
                    salVal = false;
                }
                else{
                    salVal = true;
                }
            }while(salVal==false);//este ciclo se repite mientras el usuario introduzca un numero no valido
            Sala salaSeleccionada = salas.get(opcionSala-1);//creamos una variable tipo sala en la que asignaremos la sala seleccionada


            salaSeleccionada.setFueradeserv(true);//a la sala seleccionada la asignamos fuera de servicio
            System.out.println("La sala con el codigo " + salaSeleccionada.getCodigo() + " de la sucursal " + sucursalSeleccionada.getNombre() + " ha sido marcada como fuera de servicio.");
        }
        }
    }




    //Para guardar el archivo que contiene la informacion de las sucursales con sus respectivas salas
    public void guardarArchivo(ArrayList<Sucursal> sucursales) throws IOException{
        try(FileWriter fw = new FileWriter("SucursalesYSalas.txt")){ //creamos el archivo donde vamos a guardar la informacion
            for(Sucursal sucursal: sucursales){ //recorremos las sucursales y mandamos al archivo sus respectivas descripciones
                String linea1 = "\n----Sucursal " + sucursal.getNombre() + "----"+ "\n"
                    + "Ubicacion: " + sucursal.getUbicacion() + "\n"
                    + "RFC: " + sucursal.getRfc() + "\n"
                    + "Fuera de servicio: " + sucursal.isFueradeserv() + "\n"
                    + "Salas: " + "\n";
                System.out.println(linea1);
                fw.write(linea1); //lo escribimos en el archivo
                for(Sala sala: sucursal.getSalas()){ //ahora recorremos las salas dentro de las sucursales y mandamos al archivo sus respectivas descripciones
                    String linea2 = "\t\nCodigo de la sala: " + sala.getCodigo() + "\n"
                        + "\tTamano: " + sala.getTamano() + "\n"
                        + "\tNumero de asientos: " + sala.getNumasientos() + "\n"
                        + "\tTipo: " + sala.getTiposala() + "\n"
                        + "\tFuera de servicio: " + sala.isFueradeserv() + "\n";
                    System.out.println(linea2);
                    fw.write(linea2);
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
