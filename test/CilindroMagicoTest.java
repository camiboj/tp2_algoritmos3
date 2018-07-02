import modelo.cartas.*;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.cartasTrampa.CilindroMagico;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CilindroMagicoTest {
    @Test
    public void ColocarCartaTrampaBocaAbajoEnCampoParaJugador1() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        Carta cilindro_magico = new CilindroMagico();
        InvocacionDefault InvocacionCilindroMagico = new InvocacionDefault(cilindro_magico);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante, null); // No requiere sacrificios
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora, null); // No requiere sacrificios
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        tablero.colocarZonaTrampaMagica(InvocacionCilindroMagico,jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorAtacante);
        assertFalse(cementerio.existe(cartaAtacante));
        Cementerio cementerio2= tablero.mostrarCementerio(jugadorDefensor);
        assertTrue(cementerio2.existe(cilindro_magico));
        int numeroAtaque = cartaAtacante.obtenerPuntosAtaque().obtenerNumero();
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000 - numeroAtaque);
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
    }
}
