import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Scanner;
import jdk.internal.access.JavaIOFileDescriptorAccess;

public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void crearHabitaciones(ArrayList<JSONObject> listaHabitaciones) {
        for (int id = 0; id < 10; id ++){
            JSONObject Hab = new JSONObject();
            Hab.put("id", id);
            Hab.put("estado", "D");
            Hab.put("noches", 0);
            Hab.put("precio", 0);

            agregarHabitacion(listaHabitaciones, Hab);
        }
    }

    public static void agregarHabitacion(ArrayList<JSONObject> listaHabitaciones, JSONObject json) {
        listaHabitaciones.add(json);
    }

    public static int encontrarHabitacion(ArrayList<JSONObject> listaHabitaciones, int ID){
        int index = 0;
        for (int indice = 0; indice < listaHabitaciones.size(); indice ++){
            if (Integer.parseInt(listaHabitaciones.get(indice).get("id").toString()) == ID){
                index = indice;
            }
        }
        return index;
    }
    public static void checkout(JSONObject Habitacion){
        imprimirBoleta(Habitacion);
        Habitacion.put("estado", "D");
        Habitacion.put("noches", 0);
        Habitacion.put("precio", 0);
    }

    public static  void imprimirBoleta(JSONObject Habitacion){
        int OA = 30000;
        int OS = 45000;

        int noches = Integer.parseInt(Habitacion.get("noches").toString());
        System.out.println("Estado: " +Habitacion.get("estado"));
        System.out.println("Noches: " +Habitacion.get("noches"));
        if (Habitacion.get("estado") == "OA")
            System.out.println("Precio: " + (noches * OA));
        else {
            System.out.println("Precio: " + (noches * OS));
        }
    }

    public static void mostrarHabitaciones(ArrayList<JSONObject> listaHabitaciones){
        System.out.println("\nHabitaciones existentes: ");
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            mostrarHabitacion(listaHabitaciones.get(i));
        }
    }
    public static void mostrarHabitacion(JSONObject habitacion){
        System.out.println();
        System.out.println("id: " + habitacion.get("id"));
        System.out.println("estado: " + habitacion.get("estado"));
        System.out.println("noches: " + habitacion.get("noches"));
        System.out.println("precio: " + habitacion.get("precio"));
    }


    public static boolean estaOcupada(JSONObject habitacion){
        if(habitacion.get("estado").equals("OA") || habitacion.get("estado").equals("OS")) {
            return true;
        }else {
            return false;
        }
    }
    public static String lecturaString(){
        Scanner leer = new Scanner(System.in);
        return leer.next();
    }

    public static int lecturaInt(){
        Scanner leer = new Scanner(System.in);
        return leer.nextInt();
    }

    public static String ocuparHab(){
        String estado = "";
        System.out.println("[1] Ocupar con comida $45.000 CLP");
        System.out.println("[2] Ocupar sin comida $30.000 CLP");
        String respuesta = lecturaString();
        if(respuesta.equals("1")){
            estado = "OA";
        } else if (respuesta.equals("2")) {
            estado = "OS";
        }
        return estado;
    }
    public static void reservarHab(JSONObject habitacion){
        if(estaOcupada(habitacion)){
            System.out.println("La cabaña ya está ocupada");
        }else {
            habitacion.put("estado", "R");
        }
    }

    public static void hacerResetAll(ArrayList<JSONObject> listaHabitaciones) {

        System.out.println("Esta seguro que desea resetear todas las habiaciones?" +
                "Esto eliminara todas las reservas y/o cabañas ocupadas. Ingrese [0] para confirmar. Presione cuaqluier otra tecla para cancelar.");

        String seleccion = lecturaString();

        if (seleccion.equals("0")) {

            resetAll(listaHabitaciones);

        } else {
            System.out.println("No se resetearon las habitaciones.");
        }

    }

    public static int resetAll(ArrayList<JSONObject> listaHabitaciones) {
        listaHabitaciones.clear();
        crearHabitaciones(listaHabitaciones);
        return listaHabitaciones.size();
    }

    public static void actualizarPrecio (JSONObject habitacion) {

        if( habitacion.get("estado").equals("OA") ) {
            habitacion.put("precio", 30000);
        } else if (habitacion.get("estado").equals("OS")) {
            habitacion.put("precio", 45000);
        }

    }

    public static void actualizarNoches(JSONObject habitacion){
        System.out.println("Ingrese la cantidad de noches que va a ocupar");
        int noches = lecturaInt();
        habitacion.put("noches", noches);
    }

    public static void actualizarOcupada(JSONObject habitacion){
        if(estaOcupada(habitacion)){
            System.out.println("La cabaña ya está ocupada");
        }else{
            habitacion.put("estado",ocuparHab());
            actualizarPrecio(habitacion);
            actualizarNoches(habitacion);
        }
    }

    public static void menuPrincipal(){
        ArrayList<JSONObject> listaHabitaciones = new ArrayList<>();
        crearHabitaciones(listaHabitaciones);

        int continuar = 0;

        do {
            System.out.println("\nMENU PRINCIPAL: ");
            System.out.println("[1] Mostrar Habitaciones");
            System.out.println("[2] Reservar Habitaciones");
            System.out.println("[3] Ocupar Habitacion");
            System.out.println("[4] Imprimir Boleta");
            System.out.println("[5] Reset All");
            System.out.println("Ingrese una opcion: ");
            int resultado = lecturaInt();

            switch (resultado){
                case 0 -> continuar = 1;
                case 1 -> mostrarHabitaciones(listaHabitaciones);
                case 2 ->B_hacerReserva(listaHabitaciones);
                case 3 ->B_ocuparHabitacion(listaHabitaciones);
                case 4 -> B_checkout(listaHabitaciones);
                case 5 -> hacerResetAll(listaHabitaciones);
                default -> {System.out.println("Ingese opcion valida:");}
            }

        }while (continuar != 1);



    }
    public static void B_hacerReserva(ArrayList<JSONObject> listaHabitaciones){
        mostrarHabitaciones(listaHabitaciones);
        System.out.println("Ingrese la id de la habitacion");
        int id = lecturaInt();
        int indice = encontrarHabitacion(listaHabitaciones, id);
        JSONObject habitacion = listaHabitaciones.get(indice);
        reservarHab(habitacion);
    }

    public static void B_ocuparHabitacion(ArrayList<JSONObject> listaHabitaciones){
        mostrarHabitaciones(listaHabitaciones);
        System.out.println("Ingrese la id de la habitacion");
        int id = lecturaInt();
        int indice = encontrarHabitacion(listaHabitaciones, id);
        JSONObject habitacion = listaHabitaciones.get(indice);
        actualizarOcupada(habitacion);

    }

    public static void B_checkout(ArrayList<JSONObject> listaHabitaciones){
        mostrarHabitaciones(listaHabitaciones);
        System.out.println("Ingrese la id de la habitacion");
        int id = lecturaInt();
        int indice = encontrarHabitacion(listaHabitaciones, id);
        JSONObject habitacion = listaHabitaciones.get(indice);
        checkout(habitacion);
    }

}