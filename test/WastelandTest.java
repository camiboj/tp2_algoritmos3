import modelo.cartas.cartasCampo.Wasteland;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;

public class WastelandTest {

    @Test
    public void activacionCartaWastelandHaceLoEsperado () throws VictoriaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso monstruo1 = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica invocacionMonstruo1 = new InvocacionCartaMonstruoGenerica(monstruo1);
        AlasDeLaLlamaPerversa monstruo2 = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica invocacionMonstruo2 = new InvocacionCartaMonstruoGenerica(monstruo2);
        try {
            tablero.colocarZonaMonstruo(invocacionMonstruo1, jugador1);
            tablero.colocarZonaMonstruo(invocacionMonstruo2, jugador2);
        } catch (ZonaMonstruoLlenaException e) {
            e.printStackTrace();
        }
        ZonaMonstruo zonaMonstruo1 = tablero.mostrarZonaMonstruo(jugador1);
        ZonaMonstruo zonaMonstruo2 = tablero.mostrarZonaMonstruo(jugador2);
        //Verifico que los dos monstruos están en el campo
        assertTrue(zonaMonstruo1.existe(monstruo1) && zonaMonstruo2.existe(monstruo2));

        Wasteland wasteland = new Wasteland(zonaMonstruo1, zonaMonstruo2);
        InvocacionDefault invocacionWasteland = new InvocacionDefault(wasteland);
        try {
            tablero.colocarZonaCampo(invocacionWasteland, jugador1);
        } catch (VictoriaException e) {
            //no deberia dispararse esta excepcion
            assertTrue(false);
        }


        assertTrue(monstruo1.obtenerPuntosAtaque().obtenerNumero() == 800);
        assertTrue(monstruo1.obtenerPuntosDefensa().obtenerNumero() == 900);
        assertTrue(monstruo2.obtenerPuntosAtaque().obtenerNumero() == 700);
        assertTrue(monstruo2.obtenerPuntosDefensa().obtenerNumero() == 900);
    }
}
