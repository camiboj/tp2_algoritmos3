import cartas.*;
import jugador.Jugador;
import org.junit.Test;
import tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class WastelandTest {

    @Test
    public void activacionCartaWastelandHaceLoEsperado () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso monstruo1 = new HuevoMonstruoso();
        InvocacionCartaMonstruo  invocacionMonstruo1 = new InvocacionCartaMonstruo (monstruo1, null);
        AlasDeLaLlamaPerversa monstruo2 = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruo invocacionMonstruo2 = new InvocacionCartaMonstruo(monstruo2, null);
        tablero.colocarZonaMonstruo(invocacionMonstruo1, jugador1);
        tablero.colocarZonaMonstruo(invocacionMonstruo2, jugador2);
        List<CartaMonstruo> monstruosJugador1 = new ArrayList<>();
        monstruosJugador1.add(monstruo1);
        List<CartaMonstruo> monstruosJugador2= new ArrayList<>();
        monstruosJugador2.add(monstruo2);
        Wasteland wasteland = new Wasteland();
        InvocacionCartaCampo invocacionWasteland = new InvocacionCartaCampo(wasteland, monstruosJugador1, monstruosJugador2);
        tablero.colocarZonaCampo(invocacionWasteland, jugador1);

        //assertTrue(monstruo1.obtenerPuntosAtaque().obtenerNumero() == 800);
        //assertTrue(monstruo1.obtenerPuntosDefensa().obtenerNumero() == 900);
    }
}
