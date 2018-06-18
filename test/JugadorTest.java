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
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElDefensorVaAlCementerio () {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        cartaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        cartaAtacante.invocar();
        cartaDefensora.modoDeAtaque();
        cartaAtacante.modoDeAtaque();
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorDefensor);
        assertTrue(cementerio.existe(cartaDefensora));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElDefensorPierdePuntos () {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        cartaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        cartaAtacante.invocar();
        cartaDefensora.modoDeAtaque();
        cartaAtacante.modoDeAtaque();
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        assertTrue(jugadorDefensor.obtenerPuntos().equals(new Punto(8000 - 100)) &&
                    jugadorAtacante.obtenerPuntos().equals(new Punto(8000)));
    }


    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElAtacanteVaAlCementerio () {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        cartaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        cartaDefensora.invocar();
        cartaAtacante.modoDeAtaque();
        cartaDefensora.modoDeAtaque();
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorAtacante);
        assertTrue(cementerio.existe(cartaAtacante));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElAtacantePierdePuntos () {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        cartaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        cartaDefensora.invocar();
        cartaAtacante.modoDeAtaque();
        cartaDefensora.modoDeAtaque();
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        assertTrue(jugadorAtacante.obtenerPuntos().equals(new Punto(8000 - 100)) &&
                jugadorDefensor.obtenerPuntos().equals(new Punto(8000)));
    }
}
