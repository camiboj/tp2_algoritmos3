import cartas.*;
import jugador.Jugador;
import jugador.Punto;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Jinzo7Test {

    @Test
    public void Jinzo7PuedeAtacarPuntosDeVidaDirectamente() {
        Jugador jugador = new Jugador();
        Jugador jugadorOponente = new Jugador();
        Tablero tablero = new Tablero(jugador, jugadorOponente);

        IdoloDeLosMilOjos cartaSobreviviente = new IdoloDeLosMilOjos();
        InvocacionCartaMonstruo invocacionSobreviviente = new InvocacionCartaMonstruo(cartaSobreviviente, null);
        tablero.colocarZonaMonstruo(invocacionSobreviviente, jugadorOponente);

        Jinzo7 jinzo7 = new Jinzo7(tablero, jugador);
        InvocacionCartaMonstruo invocacionJinzo7 = new InvocacionCartaMonstruo(jinzo7, null);
        tablero.colocarZonaMonstruo(invocacionJinzo7, jugador);

        Cementerio cementerioJugador = tablero.mostrarCementerio(jugador);
        ZonaMonstruo zonaMonstruoJugador = tablero.mostrarZonaMonstruo(jugador);
        Cementerio cementerioOponente = tablero.mostrarCementerio(jugadorOponente);
        ZonaMonstruo zonaMonstruoOponente = tablero.mostrarZonaMonstruo(jugadorOponente);

        assertTrue(jugador.obtenerPuntos().equals(new Punto(8000)) &&
                jugadorOponente.obtenerPuntos().equals(new Punto(8000 - 500)));

        assertFalse(cementerioOponente.existe(cartaSobreviviente));
        assertTrue(zonaMonstruoOponente.existe(cartaSobreviviente));
        assertFalse(cementerioJugador.existe(jinzo7));
        assertTrue(zonaMonstruoJugador.existe(jinzo7));
    }
}