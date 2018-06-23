import jugador.Jugador;
import jugador.YuGiOh;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class FinMazoTest {
    @Test
    public void agarrarTodasCartasMazoTerminaJuego() {

        YuGiOh juego = new YuGiOh();
        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();

        for(int i = 0; i<35; i++) {
            jugador1.sacarCarta();
        }

        assertTrue(jugador1.pierde() && jugador2.gana());
        assertFalse(jugador1.gana() && jugador2.pierde());
        assertTrue(juego.finDelJuego());
    }
}
