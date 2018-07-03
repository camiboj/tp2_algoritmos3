import modelo.excepciones.FinDelJuegoException;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class FinMazoTest {
    @Test
    public void agarrarTodasCartasMazoTerminaJuego() throws VictoriaException {

        YuGiOh juego = new YuGiOh();
        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();

        for(int i = 0; i<35; i++) {
            try {
                jugador1.sacarCarta();
            } catch (FinDelJuegoException e) {
                assertTrue(jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana());
                assertFalse(jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
                assertTrue(juego.finDelJuego());
            }
        }

        assertTrue(jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana());
        assertFalse(jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
        assertTrue(juego.finDelJuego());
    }
    @Test
    public void agarrarMuchoMasQueTodasCartasMazoTerminaJuego() throws VictoriaException {

        YuGiOh juego = new YuGiOh();
        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();

        for(int i = 0; i<135; i++) {
            try {
                jugador1.sacarCarta();
            } catch (FinDelJuegoException e) {
                assertTrue(jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana());
                assertFalse(jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
                assertTrue(juego.finDelJuego());
            }
        }
    }
}
