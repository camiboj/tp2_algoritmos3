import cartas.Carta;
import cartas.CreadoraDeCartas;
import cartas.cartasMagicas.AgujeroNegro;
import cartas.invocacion.InvocacionDefault;
import estadosDeCartas.BocaAbajo;
import excepciones.VictoriaException;
import jugador.Jugador;
import tablero.Tablero;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class CartaMagicaTest {

    @Test
    public void ColocarCartaMagicaBocaAbajo() throws VictoriaException {
        Jugador jug1 = new Jugador();
        Jugador jug2 = new Jugador();
        Tablero tablero = new Tablero(jug1, jug2);
        AgujeroNegro cualquierCarta = new AgujeroNegro(tablero);
        cualquierCarta.colocarBocaAbajo();
        assertTrue(cualquierCarta.getEstado().equals(new BocaAbajo()) );
    }

    @Test
    public void ColocarCartaMagicaBocaAbajoEnCampoParaJugador1() throws VictoriaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta unaCarta = new AgujeroNegro(tablero);
        InvocacionDefault invocacion = new InvocacionDefault(unaCarta);
        unaCarta.colocarBocaAbajo();
        assertTrue(tablero.colocarZonaTrampaMagica(invocacion, jugador1));
    }
}
