import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMagicas.Fisura;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.InvocacionExcepcion;
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
        FasePreparacion fasePreparacionSobreviviente = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionSobreviviente = new InvocacionCartaMonstruoGenerica(cartaSobreviviente,
                fasePreparacionSobreviviente);

        HuevoMonstruoso cartaAMorir = new HuevoMonstruoso();
        FasePreparacion fasePreparacionMuerto = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionMuerto = new InvocacionCartaMonstruoGenerica(cartaAMorir,
                fasePreparacionMuerto);
        try {
            tablero.colocarZonaMonstruo(invocacionSobreviviente, jugadorOponente);
            tablero.colocarZonaMonstruo(invocacionMuerto, jugadorOponente);

        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        Fisura fisura = new Fisura(tablero.mostrarLadoDelCampo(jugadorOponente));
        InvocacionDefault invocacionFisura = new InvocacionDefault(fisura);
        tablero.colocarZonaTrampaMagica(invocacionFisura, jugador);
        try {
            fisura.colocarBocaArriba();
            Cementerio cementerio = tablero.mostrarCementerio(jugadorOponente);
            ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorOponente);

            assertTrue(cementerio.existe(cartaAMorir));
            assertFalse(zonaMonstruo.existe(cartaAMorir));

            assertFalse(cementerio.existe(cartaSobreviviente));
            assertTrue(zonaMonstruo.existe(cartaSobreviviente));
        } catch (VictoriaException e) {

            assertTrue(false);
        }


    }
}