import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.InsectoComeHombres;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.*;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

public class InsectoComeHombresTest {

    @Test
    public void InsectoComeHombreMataCartaAtacante () throws VictoriaException {

        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.colocarEnModoDeDefensa();
        FasePreparacion fasePreparacionInsecto = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionInsectoComeHombres = new InvocacionCartaMonstruoGenerica(insectoComeHombres,
                fasePreparacionInsecto);
        try {
            tablero.colocarZonaMonstruo(invocacionInsectoComeHombres, jugadorDefensor);
        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionAtacante = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionCartaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtacante);
        try {
            tablero.colocarZonaMonstruo(invocacionCartaAtacante, jugadorAtacante);
        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }



        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, insectoComeHombres, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            fail();
        }
        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, insectoComeHombres, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            assertTrue(true);
        }

        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
    }
}

