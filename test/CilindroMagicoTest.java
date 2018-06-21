import cartas.*;
import cartas.cartasMonstruo.AlasDeLaLlamaPerversa;
import cartas.cartasMonstruo.HuevoMonstruoso;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
import cartas.invocacion.InvocacionDefault;
import jugador.Jugador;
import jugador.Punto;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CilindroMagicoTest {
    @Test
    public void ColocarCartaTrampaBocaAbajoEnCampoParaJugador1() {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        Carta cilindro_magico = CreadoraDeCartas.crearCarta("Cilindro Magico");
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
        assertTrue(jugadorDefensor.obtenerPuntos().equals(new Punto(8000)) &&
                jugadorAtacante.obtenerPuntos().equals(new Punto((8000 - numeroAtaque))));
    }
}
