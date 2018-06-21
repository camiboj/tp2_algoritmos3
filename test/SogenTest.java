import cartas.cartasCampo.Sogen;
import cartas.cartasMonstruo.AlasDeLaLlamaPerversa;
import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.HuevoMonstruoso;
import cartas.invocacion.InvocacionCartaCampo;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
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

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso monstruo1 = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica invocacionMonstruo1 = new InvocacionCartaMonstruoGenerica(monstruo1, null);
        AlasDeLaLlamaPerversa monstruo2 = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica invocacionMonstruo2 = new InvocacionCartaMonstruoGenerica(monstruo2, null);
        tablero.colocarZonaMonstruo(invocacionMonstruo1, jugador1);
        tablero.colocarZonaMonstruo(invocacionMonstruo2, jugador2);
        ZonaMonstruo zonaMonstruo1 = tablero.mostrarZonaMonstruo(jugador1);
        ZonaMonstruo zonaMonstruo2 = tablero.mostrarZonaMonstruo(jugador2);
        //Verifico que los dos monstruos están en el campo
        assertTrue(zonaMonstruo1.existe(monstruo1) && zonaMonstruo2.existe(monstruo2));


        List <CartaMonstruo> monstruosJugador1 = new ArrayList <>();
        monstruosJugador1.add(monstruo1);
        List <CartaMonstruo> monstruosJugador2 = new ArrayList <>();
        monstruosJugador2.add(monstruo2);
        Sogen sogen = new Sogen();
        InvocacionCartaCampo invocacionSogen = new InvocacionCartaCampo(sogen, monstruosJugador1, monstruosJugador2);
        tablero.colocarZonaCampo(invocacionSogen, jugador2, jugador1); //Si falla ver acá. Pasamos los jugadores al revés.

        assertTrue(monstruo1.obtenerPuntosAtaque().obtenerNumero() == 600);
        assertTrue(monstruo1.obtenerPuntosDefensa().obtenerNumero() == 1400);
        assertTrue(monstruo2.obtenerPuntosAtaque().obtenerNumero() == 900);
        assertTrue(monstruo2.obtenerPuntosDefensa().obtenerNumero() == 600);
    }
}
