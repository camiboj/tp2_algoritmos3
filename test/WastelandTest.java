import cartas.cartasCampo.Wasteland;
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

import static junit.framework.TestCase.assertTrue;

public class WastelandTest {

    @Test
    public void activacionCartaWastelandHaceLoEsperado () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso monstruo1 = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica invocacionMonstruo1 = new InvocacionCartaMonstruoGenerica(monstruo1);
        AlasDeLaLlamaPerversa monstruo2 = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica invocacionMonstruo2 = new InvocacionCartaMonstruoGenerica(monstruo2);
        tablero.colocarZonaMonstruo(invocacionMonstruo1, jugador1);
        tablero.colocarZonaMonstruo(invocacionMonstruo2, jugador2);
        ZonaMonstruo zonaMonstruo1 = tablero.mostrarZonaMonstruo(jugador1);
        ZonaMonstruo zonaMonstruo2 = tablero.mostrarZonaMonstruo(jugador2);
        //Verifico que los dos monstruos están en el campo
        assertTrue(zonaMonstruo1.existe(monstruo1) && zonaMonstruo2.existe(monstruo2));

        /*
        List<CartaMonstruo> monstruosJugador1 = new ArrayList<>();
        monstruosJugador1.add(monstruo1);
        List<CartaMonstruo> monstruosJugador2= new ArrayList<>();
        monstruosJugador2.add(monstruo2);
        */
        Wasteland wasteland = new Wasteland(zonaMonstruo1, zonaMonstruo2);
        InvocacionDefault invocacionWasteland = new InvocacionDefault(wasteland);
        tablero.colocarZonaCampo(invocacionWasteland, jugador1);


        assertTrue(monstruo1.obtenerPuntosAtaque().obtenerNumero() == 800);
        assertTrue(monstruo1.obtenerPuntosDefensa().obtenerNumero() == 900);
        assertTrue(monstruo2.obtenerPuntosAtaque().obtenerNumero() == 700);
        assertTrue(monstruo2.obtenerPuntosDefensa().obtenerNumero() == 900);
    }
}
