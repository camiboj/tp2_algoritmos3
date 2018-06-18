import cartas.*;
import jugador.Jugador;
import jugador.Punto;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class JugadorTest {

    @Test
     public void DosJugadoresTiranSusCartas () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta carta1 = manager.crearCarta("Agujero Negro");
        Carta carta2 = manager.crearCarta("Cilindro Magico");
        assertTrue(tablero.colocarZonaTrampaMagica(carta1, jugador1) && tablero.colocarZonaTrampaMagica(carta2, jugador2));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElPerdedorVaAlCementerio () {
        Jugador jugadorPerdedor = new Jugador();
        Jugador jugadorGanador = new Jugador();
        Tablero tablero = new Tablero(jugadorPerdedor, jugadorGanador);
        HuevoMonstruoso cartaPerdedora = new HuevoMonstruoso();
        cartaPerdedora.invocar();
        AlasDeLaLlamaPerversa cartaGanadora = new AlasDeLaLlamaPerversa();
        cartaGanadora.invocar();
        cartaPerdedora.modoDeAtaque();
        cartaGanadora.modoDeAtaque();
        tablero.colocarZonaMonstruo(cartaPerdedora, jugadorPerdedor);
        tablero.colocarZonaMonstruo(cartaGanadora, jugadorGanador);
        tablero.atacarDosMonstruos(cartaGanadora, jugadorGanador, cartaPerdedora, jugadorPerdedor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorPerdedor);
        assertTrue(cementerio.existe(cartaPerdedora));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElPerdedorPierdePuntos () {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso carta1 = new HuevoMonstruoso();
        carta1.invocar();
        AlasDeLaLlamaPerversa carta2 = new AlasDeLaLlamaPerversa();
        carta2.invocar();
        carta1.modoDeAtaque();
        carta2.modoDeAtaque();
        tablero.colocarZonaMonstruo(carta1, jugador1);
        tablero.colocarZonaMonstruo(carta2, jugador2);
        tablero.atacarDosMonstruos(carta2, jugador2, carta1, jugador1);
        assertTrue(jugador1.obtenerPuntos().equals(new Punto(8000 - 100)) &&
                    jugador2.obtenerPuntos().equals(new Punto(8000)));
    }

}
