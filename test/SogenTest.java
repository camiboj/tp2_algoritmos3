import modelo.cartas.cartasCampo.Sogen;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static org.junit.Assert.assertTrue;

public class SogenTest {

    @Test
    public void activacionCartaSogenHaceLoEsperado () throws VictoriaException {

        Jugador jugadorSogen = new Jugador();
        Jugador otroJugador = new Jugador();
        Tablero tablero = new Tablero(jugadorSogen, otroJugador);

        HuevoMonstruoso monstruoLadoSogen = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica invocacionMonstuoLadoSogen = new InvocacionCartaMonstruoGenerica(monstruoLadoSogen);
        tablero.colocarZonaMonstruo(invocacionMonstuoLadoSogen, jugadorSogen);

        AlasDeLaLlamaPerversa otroMonstruo = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica invocacionOtroMonstruo = new InvocacionCartaMonstruoGenerica(otroMonstruo);
        tablero.colocarZonaMonstruo(invocacionOtroMonstruo, otroJugador);

        ZonaMonstruo zonaMonstruoSogen = tablero.mostrarZonaMonstruo(jugadorSogen);
        ZonaMonstruo zonaMonstruoOtro = tablero.mostrarZonaMonstruo(otroJugador);

        //Verifico que los dos monstruos están en el campo
        assertTrue(zonaMonstruoSogen.existe(monstruoLadoSogen) && zonaMonstruoOtro.existe(otroMonstruo));

        Sogen sogen = new Sogen(zonaMonstruoSogen, zonaMonstruoOtro);
        InvocacionDefault invocacionSogen = new InvocacionDefault(sogen);
        try {
            tablero.colocarZonaCampo(invocacionSogen, jugadorSogen);
        } catch (VictoriaException e) {
            //no deberia dispararse esta excepcion
            assertTrue(false);
        }


        assertTrue(monstruoLadoSogen.obtenerPuntosAtaque().obtenerNumero() == 600);
        assertTrue(monstruoLadoSogen.obtenerPuntosDefensa().obtenerNumero() == 1400);
        assertTrue(otroMonstruo.obtenerPuntosAtaque().obtenerNumero() == 900);
        assertTrue(otroMonstruo.obtenerPuntosDefensa().obtenerNumero() == 600);
    }
}
