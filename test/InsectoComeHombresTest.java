import modelo.cartas.cartasMonstruo.InsectoComeHombres;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
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

public class InsectoComeHombresTest {

    @Test
    public void InsectoComeHombreMataCartaAtacante () throws VictoriaException {

        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.colocarEnModoDeDefensa();

        InvocacionCartaMonstruoGenerica invocacionInsectoComeHombres = new InvocacionCartaMonstruoGenerica(insectoComeHombres);
        try {
            tablero.colocarZonaMonstruo(invocacionInsectoComeHombres, jugadorDefensor);
        } catch (ZonaMonstruoLlenaException e) {
        }

        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica invocacionCartaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante);
        try {
            tablero.colocarZonaMonstruo(invocacionCartaAtacante, jugadorAtacante);
        } catch (ZonaMonstruoLlenaException e) {
        }

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

