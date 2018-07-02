import modelo.cartas.invocacion.InvocacionDefault;
import modelo.cartas.cartasMagicas.OllaDeLaCodicia;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;


public class OllaDeLaCodiciaTest {


    @Test
    public void ollaDeLaCodiciaTest() throws  VictoriaException {
        assertTrue(true);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);
        InvocacionDefault invocacionOllaDeLaCodicia = new InvocacionDefault(ollaDeLaCodicia);
        tablero.colocarZonaTrampaMagica(invocacionOllaDeLaCodicia, jugador1);
        try {
            ollaDeLaCodicia.colocarBocaArriba();
        } catch (VictoriaException e) {
            //no deberia dispararse esta excepcion
            assertTrue(false);
        }

        assertTrue((jugador1.cantidadDeCartasEnMazo() == 33));


    }
}
