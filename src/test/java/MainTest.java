import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<JSONArray> listaHabitaciones = new ArrayList<JSONArray>();

    @BeforeEach
    void setUp() {
        JSONObject habitacion1 = new JSONObject();
        habitacion1.put("id","1");
        habitacion1.put("estado",0);
        habitacion1.put("noches",0);
        habitacion1.put("precio",0);

        JSONObject habitacionOcupada = new JSONObject();
        habitacion1.put("id","1");
        habitacion1.put("estado","OC");
        habitacion1.put("noches",0);
        habitacion1.put("precio",0);



    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mostrarHabitaciones() {
    }

    @Test
    void mostrarCabaña() {
    }

    @Test
    void hacerReserva() {
    }

    @Test
    void reservarHab() {}{

    }
}