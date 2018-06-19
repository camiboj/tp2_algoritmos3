import cartas.*;
import jugador.Jugador;
import jugador.Punto;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class AtaqueMonstruosTest {

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
        //cartaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        //cartaAtacante.invocar();
        cartaDefensora.colocarEnModoDeAtaque();
        cartaAtacante.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorDefensor);
        assertTrue(cementerio.existe(cartaDefensora));
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertFalse(zonaMonstruo.existe(cartaDefensora));

    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElDefensorPierdePuntos () {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        //cartaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        //cartaAtacante.invocar();
        cartaDefensora.colocarEnModoDeAtaque();
        cartaAtacante.colocarEnModoDeAtaque();
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
        //cartaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        //cartaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorAtacante);
        assertTrue(cementerio.existe(cartaAtacante));
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorAtacante);
        assertFalse(zonaMonstruo.existe(cartaAtacante));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElAtacantePierdePuntos () {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        //cartaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        //cartaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        assertTrue(jugadorAtacante.obtenerPuntos().equals(new Punto(8000 - 100)) &&
                jugadorDefensor.obtenerPuntos().equals(new Punto(8000)));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyAmbosVanAlCementerio () {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        //cartaAtacante.invocar();
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        //cartaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerioDefensor = tablero.mostrarCementerio(jugadorDefensor);
        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        assertTrue(cementerioDefensor.existe(cartaDefensora) && cementerioAtacante.existe(cartaAtacante));        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorAtacante);
        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
        ZonaMonstruo zonaMonstruoDefensor = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertFalse(zonaMonstruoAtacante.existe(cartaAtacante) && zonaMonstruoDefensor.existe(cartaDefensora));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyNadiePierdePuntos () {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);
        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        //cartaAtacante.invocar();
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        //cartaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        assertTrue(jugadorAtacante.obtenerPuntos().equals(new Punto(8000)) &&
                jugadorDefensor.obtenerPuntos().equals(new Punto(8000)));
    }
}
