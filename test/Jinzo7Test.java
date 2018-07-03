import modelo.cartas.cartasMonstruo.cartasBasicas.IdoloDeLosMilOjos;
import modelo.cartas.cartasMonstruo.Jinzo7;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Jinzo7Test {

    @Test
    public void Jinzo7PuedeAtacarPuntosDeVidaDirectamente() throws  VictoriaException {
        Jugador jugador = new Jugador();
        Jugador jugadorOponente = new Jugador();
        Tablero tablero = new Tablero(jugador, jugadorOponente);

        IdoloDeLosMilOjos cartaSobreviviente = new IdoloDeLosMilOjos();
        InvocacionCartaMonstruoGenerica invocacionSobreviviente = new InvocacionCartaMonstruoGenerica(cartaSobreviviente);
        try {
            tablero.colocarZonaMonstruo(invocacionSobreviviente, jugadorOponente);
        } catch (ZonaMonstruoLlenaException e) {
        }

        Jinzo7 jinzo7 = new Jinzo7(jugadorOponente);
        InvocacionCartaMonstruoGenerica invocacionJinzo7 = new InvocacionCartaMonstruoGenerica(jinzo7);
        try {
            tablero.colocarZonaMonstruo(invocacionJinzo7, jugador);
        } catch (ZonaMonstruoLlenaException e) {
        }
        try {
            jinzo7.colocarBocaArriba();
        } catch (VictoriaException e) {
            assertTrue(false);
        }

        Cementerio cementerioJugador = tablero.mostrarCementerio(jugador);
        ZonaMonstruo zonaMonstruoJugador = tablero.mostrarZonaMonstruo(jugador);
        Cementerio cementerioOponente = tablero.mostrarCementerio(jugadorOponente);
        ZonaMonstruo zonaMonstruoOponente = tablero.mostrarZonaMonstruo(jugadorOponente);

        assertTrue(jugadorOponente.obtenerPuntos().obtenerNumero() == 8000-500);
        assertTrue(jugador.obtenerPuntos().obtenerNumero() == 8000);

        assertFalse(cementerioOponente.existe(cartaSobreviviente));
        assertTrue(zonaMonstruoOponente.existe(cartaSobreviviente));
        assertFalse(cementerioJugador.existe(jinzo7));
        assertTrue(zonaMonstruoJugador.existe(jinzo7));
    }
}
