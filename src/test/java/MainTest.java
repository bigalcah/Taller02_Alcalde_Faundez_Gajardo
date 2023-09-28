import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<JSONObject> listaHabitaciones = new ArrayList<>();
    JSONObject habitacion1 = new JSONObject();
    JSONObject habitacion2 = new JSONObject();

    @BeforeEach
    void setUp() {

        habitacion1.put("id",0);
        habitacion2.put("id",1);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void resetAll() {
        assertEquals(0, Main.resetAll(listaHabitaciones)) ;
    }
}