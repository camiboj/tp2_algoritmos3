import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlcanzadorDeGarra;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class DefensaMonstruoTest {
    @Test
    public void cartaEnModoDefensaEsAtacadaYGana() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora, null); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante, null); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        cartaDefensora.colocarEnModoDeDefensa();
        cartaAtacante.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora,jugadorDefensor);
        } catch (ZonaMonstruoLlenaException e) {
        }
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante,jugadorAtacante);
        } catch (ZonaMonstruoLlenaException e) {
        }
        tablero.atacarDosMonstruos(cartaAtacante,jugadorAtacante,cartaDefensora,jugadorDefensor);
        Cementerio cementerioDefensor = tablero.mostrarCementerio(jugadorDefensor);
        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        assertFalse(cementerioDefensor.existe(cartaDefensora) && cementerioAtacante.existe(cartaAtacante));
        ZonaMonstruo zonaMonstruoDefensor = tablero.mostrarZonaMonstruo(jugadorDefensor);
        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
        assertTrue(zonaMonstruoDefensor.existe(cartaDefensora) && zonaMonstruoAtacante.existe(cartaAtacante));
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
    }

    @Test
    public void cartaEnModoDefensaEsAtacadaYPierdeConPuntosDeSobra() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora, null); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        AlcanzadorDeGarra cartaAtacante = new AlcanzadorDeGarra();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante, null); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        cartaDefensora.colocarEnModoDeDefensa();
        cartaAtacante.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora,jugadorDefensor);
        } catch (ZonaMonstruoLlenaException e) {
        }
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante,jugadorAtacante);
        } catch (ZonaMonstruoLlenaException e) {
        }
        tablero.atacarDosMonstruos(cartaAtacante,jugadorAtacante,cartaDefensora,jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorDefensor);
        assertTrue(cementerio.existe(cartaDefensora));
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertFalse(zonaMonstruo.existe(cartaDefensora));
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
    }

    @Test
    public void cartaEnModoDefensaEsAtacadaYPierdeConPuntosIguales() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante, null); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora, null); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        cartaDefensora.colocarEnModoDeDefensa();
        cartaAtacante.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante,jugadorAtacante);
        } catch (ZonaMonstruoLlenaException e) {
        }
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora,jugadorDefensor);
        } catch (ZonaMonstruoLlenaException e) {
        }
        tablero.atacarDosMonstruos(cartaAtacante,jugadorAtacante,cartaDefensora,jugadorDefensor);
        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        assertFalse(cementerioAtacante.existe(cartaAtacante));
        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
        assertTrue(zonaMonstruoAtacante.existe(cartaAtacante));
        Cementerio cementerioDefensor = tablero.mostrarCementerio(jugadorDefensor);
        assertTrue(cementerioDefensor.existe(cartaDefensora));
        ZonaMonstruo zonaMonstruoDefensor = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertFalse(zonaMonstruoDefensor.existe(cartaDefensora));
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
    }
}
