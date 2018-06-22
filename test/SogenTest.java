import cartas.cartasCampo.Sogen;
import cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import cartas.invocacion.InvocacionCartaCampo;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
import cartas.invocacion.InvocacionDefault;
import jugador.Jugador;
import org.junit.Test;
import tablero.Tablero;
import tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SogenTest {

    @Test
    public void activacionCartaSogenHaceLoEsperado () {

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


       /* List <CartaMonstruo> monstruosJugador1 = new ArrayList <>();
        monstruosJugador1.add(monstruo1);
        List <CartaMonstruo> monstruosJugador2 = new ArrayList <>();
        monstruosJugador2.add(monstruo2);*/
        Sogen sogen = new Sogen(zonaMonstruoSogen, zonaMonstruoOtro);
        InvocacionDefault invocacionSogen = new InvocacionDefault(sogen);
        //InvocacionCartaCampo invocacionSogen = new InvocacionCartaCampo(sogen, monstruosJugador1, monstruosJugador2);
        tablero.colocarZonaCampo(invocacionSogen, jugadorSogen); //Si falla ver acá. Pasamos los jugadores al revés.

        int ataqueHuevoMonstruoso = otroMonstruo.obtenerPuntosAtaque().obtenerNumero();
        System.out.println(ataqueHuevoMonstruoso);

        assertTrue(monstruoLadoSogen.obtenerPuntosAtaque().obtenerNumero() == 600);
        assertTrue(monstruoLadoSogen.obtenerPuntosDefensa().obtenerNumero() == 1400);
        assertTrue(otroMonstruo.obtenerPuntosAtaque().obtenerNumero() == 900);
        assertTrue(otroMonstruo.obtenerPuntosDefensa().obtenerNumero() == 600);
    }
}
