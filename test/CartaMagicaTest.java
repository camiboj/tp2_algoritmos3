import cartas.Carta;
import cartas.CreadoraDeCartas;
import estadosDeCartas.BocaAbajo;
import jugador.Jugador;
import tablero.Tablero;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class CartaMagicaTest {

    @Test
    public void ColocarCartaMagicaBocaAbajo() {
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta cualquierCarta = manager.crearCarta("Agujero Negro");
        cualquierCarta.colocarBocaAbajo();
        assertTrue(cualquierCarta.getEstado().equals(new BocaAbajo()) );
    }

    @Test
    public void ColocarCartaMagicaBocaAbajoEnCampoParaJugador1() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta unaCarta = manager.crearCarta("Agujero Negro");
        unaCarta.colocarBocaAbajo();
        assertTrue(tablero.colocarZonaTrampaMagica(unaCarta, jugador1));
    }
}
