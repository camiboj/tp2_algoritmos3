import cartas.cartasMonstruo.InsectoComeHombres;
import cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import cartas.invocacion.InvocacionCartaMonstruo;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
import jugador.Jugador;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class InsectoComeHombresTest {

    @Test
    public void InsectoComeHombreMataCartaAtacante () {

        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.colocarEnModoDeDefensa();

        InvocacionCartaMonstruoGenerica invocacionInsectoComeHombres = new InvocacionCartaMonstruoGenerica(insectoComeHombres);
        tablero.colocarZonaMonstruo(invocacionInsectoComeHombres, jugadorDefensor);

        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica invocacionCartaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante);
        tablero.colocarZonaMonstruo(invocacionCartaAtacante, jugadorAtacante);

        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);

        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, insectoComeHombres, jugadorDefensor);
        assertFalse(zonaMonstruoAtacante.existe(cartaAtacante));

        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        assertTrue(cementerioAtacante.existe(cartaAtacante));

        ZonaMonstruo zonaMonstruoDefensor = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertTrue(zonaMonstruoDefensor.existe(insectoComeHombres));

        Cementerio cementerioDefensor = tablero.mostrarCementerio(jugadorDefensor);
        assertFalse(cementerioDefensor.existe(insectoComeHombres));

        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
    }
}

