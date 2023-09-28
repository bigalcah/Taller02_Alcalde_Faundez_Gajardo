import org.json.JSONObject;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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

    public static int encontrarHabitacion(ArrayList<JSONObject> listaHabitaciones, String ID){
        int index = 0;
        for (int indice = 0; indice < listaHabitaciones.size(); indice ++){
            if ((listaHabitaciones.get(indice)).get("id") == ID){
                 index = indice;
            }
        }
        return index;
    }
    public static void checkout(JSONObject Habitacion){
        Habitacion.put("estado", "D");
        Habitacion.put("noches", 0);
        Habitacion.put("precio", 0);
    }

    public static  void imprimirCCheckout(JSONObject Habitacion){

    }


}
