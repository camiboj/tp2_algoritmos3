import modelo.cartas.invocacion.InvocacionDefault;
import modelo.cartas.cartasMagicas.OllaDeLaCodicia;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaTrampaMagicaLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;


public class OllaDeLaCodiciaTest {


    @Test
    public void ollaDeLaCodiciaTest() throws  VictoriaException {
        assertTrue(true);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia();
        InvocacionDefault invocacionOllaDeLaCodicia = new InvocacionDefault(ollaDeLaCodicia);

        try {
            tablero.colocarZonaTrampaMagica(invocacionOllaDeLaCodicia, jugador1);
            ollaDeLaCodicia.colocarBocaArriba();
        }
        catch (ZonaTrampaMagicaLlenaException e) {
            //no deberia dispararse esta excepcion
            fail();
        }

        assertTrue((jugador1.cantidadDeCartasEnMazo() == 33));


    }
}
