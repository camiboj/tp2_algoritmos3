import modelo.Fase.FasePreparacion;
import modelo.cartas.*;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.cartasTrampa.CilindroMagico;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.*;
import modelo.jugador.Jugador;
import modelo.tablero.ZonaTrampaMagica;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
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
        FasePreparacion fasePreparacionAtacante = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtacante); // No requiere sacrificios

        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa); // No requiere sacrificios

        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);

        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
        fail();
        }
        try {
            tablero.colocarZonaTrampaMagica(InvocacionCilindroMagico,jugadorDefensor);
        } catch (ZonaTrampaMagicaLlenaException e) {
            fail();
        }
        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            fail();
        }


        ZonaTrampaMagica zonaTrampaMagicaDefensor = tablero.mostrarZonaTrampaMagica(jugadorDefensor);
        assertFalse(zonaTrampaMagicaDefensor.existe(cilindro_magico));
        int numeroAtaque = cartaAtacante.obtenerPuntosAtaque().obtenerNumero();
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000 - numeroAtaque);
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
    }
}
