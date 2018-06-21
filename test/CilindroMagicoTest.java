import cartas.*;
import jugador.Jugador;
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
        cilindro_magico.colocarBocaAbajo();
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante, null); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora, null); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
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
        //assertTrue(tablero.colocarZonaTrampaMagica(unaInvocacion, jugadorDefensor));
    }
}
