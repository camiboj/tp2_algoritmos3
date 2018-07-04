import modelo.cartas.Carta;
import modelo.cartas.CreadoraDeCartas;
import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.estadosDeCartas.BocaAbajo;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaTrampaMagicaLlenaException;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class CartaMagicaTest {

    @Test
    public void ColocarCartaMagicaBocaAbajo() throws VictoriaException {
        Jugador jug1 = new Jugador();
        Jugador jug2 = new Jugador();
        Tablero tablero = new Tablero(jug1, jug2);
        AgujeroNegro cualquierCarta = new AgujeroNegro();
        cualquierCarta.colocarBocaAbajo();
        assertTrue(cualquierCarta.getEstado().equals(new BocaAbajo()) );
    }

    @Test
    public void ColocarCartaMagicaBocaAbajoEnCampoParaJugador1() throws VictoriaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta unaCarta = new AgujeroNegro();
        InvocacionDefault invocacion = new InvocacionDefault(unaCarta);
        unaCarta.colocarBocaAbajo();
        try {
            assertTrue(tablero.colocarZonaTrampaMagica(invocacion, jugador1) >= 0);
        } catch (ZonaTrampaMagicaLlenaException e) {
            fail();
        }
    }
}
