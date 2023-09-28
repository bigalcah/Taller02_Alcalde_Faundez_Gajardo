import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Scanner;

/*

{
"id" = 0,
"estado" = (D,R,OA,OS) ,
"noches" = 0,
"precio" = 0
}

*/
public class Main {

    public static void main(String[] args) {

    }

    public static String lectura(){
        Scanner leer = new Scanner(System.in);
        return leer.next();
    }

    public static void B_resetAll(ArrayList<JSONObject> listaHabitaciones) {

        System.out.println("Esta seguro que desea resetear todas las habiaciones?" +
                "Esto eliminara todas las reservas y/o cabañas ocupadas.");

        String seleccion = lectura();

        if (seleccion.equals("0")) {

            resetAll(listaHabitaciones);

        } else {
            System.out.println("No se resetearon las habitaciones.");
        }

    }

    public static int resetAll(ArrayList<JSONObject> listaHabitaciones) {
        listaHabitaciones.clear();
        return listaHabitaciones.size();
    }



}
