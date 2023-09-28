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
    public static void reservarHab(JSONObject habitacion){
        if(habitacion.get("estado").equals("OA") || habitacion.get("estado").equals("OS")){
            System.out.println("La cabaña ya está ocupada");
        }else {
            habitacion.put("estado", "R");
        }
    }
}
