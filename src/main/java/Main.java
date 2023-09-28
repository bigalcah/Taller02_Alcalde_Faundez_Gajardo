import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static void mostrarHabitaciones(ArrayList<JSONObject> listaHabitaciones){
        System.out.println("\nCabañas existentes: ");
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            mostrarCabaña(listaHabitaciones.get(i));
        }
    }
    public static void mostrarCabaña(JSONObject habitacion){
        System.out.println();
        System.out.println("id: " + habitacion.get("id"));
        System.out.println("estado: " + habitacion.get("estado"));
        System.out.println("noches: " + habitacion.get("noches"));
        System.out.println("precio: " + habitacion.get("precio"));
    }

    public static void hacerReserva(){

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
    public static void actualizarOcupada(JSONObject habitacion){
        if(estaOcupada(habitacion)){
            System.out.println("La cabaña ya está ocupada");
        }else{
            habitacion.put("estado",ocuparHab());
        }
    }
    public static void actualizarNoches(JSONObject habitacion){
        System.out.println("Ingrese la cantidad de noches que va a ocupar");
        int noches = lecturaInt();
        habitacion.put("noches", noches);
    }

    /*public static void menuPrincipal(){
        //inicializar metodo crear lista de hab.
        System.out.println("[1] Mostrar Habitaciones");
        System.out.println("[2] Resetear Habitaciones");
        System.out.println("[3] Imprimir Boleta");
        System.out.println("Ingrese una opcion");
        int resultado = lecturaInt();



    }*/
}
