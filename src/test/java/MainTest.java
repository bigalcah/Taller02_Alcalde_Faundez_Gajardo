import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<JSONObject> listaHabitaciones;
    ArrayList<JSONObject> listaHabitaciones2;
    JSONObject Hab;

    @BeforeEach
    void setUp() {
        Hab = new JSONObject();
        Hab.put("id", 0);
        Hab.put("estado", "D");
        Hab.put("noches", 0);
        Hab.put("precio", 0);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void crearHabitaciones() {
        listaHabitaciones = new ArrayList<JSONObject>();
        Main.crearHabitaciones(listaHabitaciones);
        assertEquals(10, listaHabitaciones.size());
    }

    @Test
    void agregarHabitacion() {
        listaHabitaciones2 = new ArrayList<JSONObject>();
        Main.agregarHabitacion(listaHabitaciones2, Hab);
        assertEquals(1, listaHabitaciones2.size());
    }
}