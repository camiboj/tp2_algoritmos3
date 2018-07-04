import modelo.Fase.FasePreparacion;
import modelo.cartas.*;
import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;

public class AtaqueMonstruosTest {

    @Test
     public void DosJugadoresTiranSusCartas () throws VictoriaException {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta carta1 = new AgujeroNegro();
        InvocacionDefault invocacion1 = new InvocacionDefault(carta1);
        Carta carta2 = new AgujeroNegro();
        InvocacionDefault invocacion2 = new InvocacionDefault(carta2);
        assertTrue(tablero.colocarZonaTrampaMagica(invocacion1, jugador1) && tablero.colocarZonaTrampaMagica(invocacion2, jugador2));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElDefensorVaAlCementerio () throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa);// No requiere sacrificios

        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque); // No requiere sacrificios

        cartaDefensora.colocarEnModoDeAtaque();
        cartaAtacante.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorDefensor);
        assertTrue(cementerio.existe(cartaDefensora));
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertFalse(zonaMonstruo.existe(cartaDefensora));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElDefensorPierdePuntos () throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        FasePreparacion fasePreparacionDefensora = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensora); // No requiere sacrificios

        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionAtacante = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtacante); // No requiere sacrificios

        cartaDefensora.colocarEnModoDeAtaque();
        cartaAtacante.colocarEnModoDeAtaque();

        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 7900);
            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElAtacanteVaAlCementerio () throws VictoriaException {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        FasePreparacion fasePreparacionAtacante = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtacante); // No requiere sacrificios

        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa); // No requiere sacrificios

        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);

        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerio = tablero.mostrarCementerio(jugadorAtacante);
        assertTrue(cementerio.existe(cartaAtacante));
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorAtacante);
        assertFalse(zonaMonstruo.existe(cartaAtacante));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyElAtacantePierdePuntos () throws VictoriaException {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque); // No requiere sacrificios

        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa); // No requiere sacrificios

        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();

        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 7900);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyAmbosVanAlCementerio () throws VictoriaException {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque); // No requiere sacrificios


        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa); // No requiere sacrificios

        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        Cementerio cementerioDefensor = tablero.mostrarCementerio(jugadorDefensor);
        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        assertTrue(cementerioDefensor.existe(cartaDefensora) && cementerioAtacante.existe(cartaAtacante));        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugadorAtacante);
        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
        ZonaMonstruo zonaMonstruoDefensor = tablero.mostrarZonaMonstruo(jugadorDefensor);
        assertFalse(zonaMonstruoAtacante.existe(cartaAtacante) && zonaMonstruoDefensor.existe(cartaDefensora));
    }

    @Test
    public void DosJugadoresPonenSusMonstruosEnPosiciondeAtaqueyNadiePierdePuntos () throws VictoriaException {
        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();
        Tablero tablero = new Tablero(jugadorAtacante, jugadorDefensor);

        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque);// No requiere sacrificios

        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa); // No requiere sacrificios

        cartaAtacante.colocarEnModoDeAtaque();
        cartaDefensora.colocarEnModoDeAtaque();
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException e) {
            fail();
        } catch (InvocacionExcepcion invocacionExcepcion) {
            fail();
        }
    }
}
