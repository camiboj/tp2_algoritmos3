import jugador.Jugador;
import org.junit.Test;
import tablero.LadoDelCampo;
import tablero.Tablero;
import tablero.Casillero;
import static junit.framework.TestCase.assertTrue;

public class TableroTest {

    @Test
    public void CrearTablero(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        assertTrue(tablero.get(jugador1).equals(new LadoDelCampo()) );
        assertTrue(tablero.get(jugador2).equals(new LadoDelCampo()) );
    }
    /*
    public void GenerarTablero() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        tablero.generarTablero();
        assertFalse(tablero.estaVacio());
    }
    */
}
