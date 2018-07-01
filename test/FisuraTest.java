import cartas.cartasMagicas.Fisura;
import cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
import cartas.invocacion.InvocacionDefault;
import excepciones.VictoriaException;
import jugador.Jugador;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FisuraTest {

    @Test
    public void FisuraTest() throws  VictoriaException {
        Jugador jugador = new Jugador();
        Jugador jugadorOponente = new Jugador();
        Tablero tablero = new Tablero(jugador, jugadorOponente);

        AlasDeLaLlamaPerversa cartaSobreviviente = new AlasDeLaLlamaPerversa();
        HuevoMonstruoso cartaAMorir = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica invocacionSobreviviente = new InvocacionCartaMonstruoGenerica(cartaSobreviviente);
        InvocacionCartaMonstruoGenerica invocacionMuerto = new InvocacionCartaMonstruoGenerica(cartaAMorir);
        tablero.colocarZonaMonstruo(invocacionSobreviviente, jugadorOponente);
        tablero.colocarZonaMonstruo(invocacionMuerto, jugadorOponente);

        Fisura fisura = new Fisura(tablero.mostrarLadoDelCampo(jugadorOponente));
        InvocacionDefault invocacionFisura = new InvocacionDefault(fisura);
        tablero.colocarZonaTrampaMagica(invocacionFisura, jugador);
        try {
            fisura.colocarBocaArriba();
        } catch (VictoriaException e) {

            assertTrue(false);
        }

        Cementerio cementerio = tablero.mostrarCementerio(jugadorOponente);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorOponente);

        assertTrue(cementerio.existe(cartaAMorir));
        assertFalse(zonaMonstruo.existe(cartaAMorir));

        assertFalse(cementerio.existe(cartaSobreviviente));
        assertTrue(zonaMonstruo.existe(cartaSobreviviente));
    }
}