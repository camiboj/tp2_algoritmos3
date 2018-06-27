import cartas.Carta;
import cartas.cartasMonstruo.exodia.*;
import excepciones.FinDelJuegoException;
import excepciones.VictoriaException;
import jugador.Jugador;
import jugador.YuGiOh;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ExodiaTest {

    @Test
    public void Tener5PartesExodiaHaceQueGanesElJuego() {

        YuGiOh juego = new YuGiOh("mazoTestExodia","jugadorPersonalizado");
        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();


        List<Carta> cartasExodia = new ArrayList<>();
        cartasExodia.add(new BrazoDerechoDelProhibido());
        cartasExodia.add(new BrazoIzquierdoDelProhibido());
        cartasExodia.add(new PiernaDerechaDelProhibido());
        cartasExodia.add(new PiernaIzquierdaDelProhibido());
        cartasExodia.add(new ExodiaElProhibido());
    try {
        jugador1.crearManoConCartas(cartasExodia);
        assertTrue(false);
    }
     catch (VictoriaException e) {
         assertTrue(e.obtenerMotivo().equals("Se Convoca a Exodia!!"));
         assertTrue(jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
         assertTrue(juego.finDelJuego());
    }


    }

}
