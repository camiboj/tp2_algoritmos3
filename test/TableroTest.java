import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.LadoDelCampo;
import modelo.tablero.Tablero;
import static junit.framework.TestCase.assertTrue;

public class TableroTest {

    @Test
    public void CrearTablero() throws VictoriaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        assertTrue(tablero.get(jugador1).equals(new LadoDelCampo()) );
        assertTrue(tablero.get(jugador2).equals(new LadoDelCampo()) );
    }

}
