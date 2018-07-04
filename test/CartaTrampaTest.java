import modelo.cartas.CreadoraDeCartas;
import modelo.cartas.cartasTrampa.CilindroMagico;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaTrampaMagicaLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class CartaTrampaTest {
    @Test
    public void ColocarCartaTrampaBocaAbajoEnCampoParaJugador1() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = null;
        try {
            tablero = new Tablero(jugador1, jugador2);
            CreadoraDeCartas manager = new CreadoraDeCartas();
            CilindroMagico unaCarta = new CilindroMagico();
            InvocacionDefault unaInvocacion = new InvocacionDefault(unaCarta);
            unaCarta.colocarBocaAbajo();
            assertTrue(tablero.colocarZonaTrampaMagica(unaInvocacion, jugador1) >= 0);
        } catch (VictoriaException | ZonaTrampaMagicaLlenaException e) {
            fail();
        }
    }


}
