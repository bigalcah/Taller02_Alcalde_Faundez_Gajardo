import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Scanner;
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
}
