import modelo.cartas.cartasMagicas.Fisura;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

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
        try {
            tablero.colocarZonaMonstruo(invocacionSobreviviente, jugadorOponente);
            tablero.colocarZonaMonstruo(invocacionMuerto, jugadorOponente);

        } catch (ZonaMonstruoLlenaException e) {
        }

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