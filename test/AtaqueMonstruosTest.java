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
        InvocacionDefault invocacion1 = new InvocacionDefault(carta1);
        Carta carta2 = manager.crearCarta("Cilindro Magico");
        InvocacionDefault invocacion2 = new InvocacionDefault(carta2);
        assertTrue(tablero.colocarZonaTrampaMagica(invocacion1, jugador1) && tablero.colocarZonaTrampaMagica(invocacion2, jugador2));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElDefensorVaAlCementerio () {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        InvocacionDefault cartaInvocadaDefensora = new InvocacionDefault(cartaDefensora); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        InvocacionDefault cartaInvocadaAtacante = new InvocacionDefault(cartaAtacante); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        cartaDefensora.colocarEnModoDeAtaque();
        cartaAtacante.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
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
        InvocacionDefault cartaInvocadaDefensora = new InvocacionDefault(cartaDefensora); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        InvocacionDefault cartaInvocadaAtacante = new InvocacionDefault(cartaAtacante); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        cartaDefensora.colocarEnModoDeAtaque();
        cartaAtacante.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
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
        InvocacionDefault cartaInvocadaAtacante = new InvocacionDefault(cartaAtacante); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        InvocacionDefault cartaInvocadaDefensora = new InvocacionDefault(cartaDefensora); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
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
        InvocacionDefault cartaInvocadaAtacante = new InvocacionDefault(cartaAtacante); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        InvocacionDefault cartaInvocadaDefensora = new InvocacionDefault(cartaDefensora); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
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
        InvocacionDefault cartaInvocadaAtacante = new InvocacionDefault(cartaAtacante); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        InvocacionDefault cartaInvocadaDefensora = new InvocacionDefault(cartaDefensora); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
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
        InvocacionDefault cartaInvocadaAtacante = new InvocacionDefault(cartaAtacante); // No requiere sacrificios
        cartaInvocadaAtacante.invocar();
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        InvocacionDefault cartaInvocadaDefensora = new InvocacionDefault(cartaDefensora); // No requiere sacrificios
        cartaInvocadaDefensora.invocar();
        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        assertTrue(jugadorAtacante.obtenerPuntos().equals(new Punto(8000)) &&
                jugadorDefensor.obtenerPuntos().equals(new Punto(8000)));
    }
}
