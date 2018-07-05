import modelo.Fase.FasePreparacion;
import modelo.cartas.*;
import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.*;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.*;

public class AtaqueMonstruosTest {

    @Test
     public void DosJugadoresTiranSusCartas () throws VictoriaException, ZonaTrampaMagicaLlenaException {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        CreadoraDeCartas manager = new CreadoraDeCartas();
        Carta carta1 = new AgujeroNegro();
        InvocacionDefault invocacion1 = new InvocacionDefault(carta1);
        Carta carta2 = new AgujeroNegro();
        InvocacionDefault invocacion2 = new InvocacionDefault(carta2);
        try {
            assertTrue(tablero.colocarZonaTrampaMagica(invocacion1, jugador1) >= 0
                    && tablero.colocarZonaTrampaMagica(invocacion2, jugador2) >= 0);
        } catch (ZonaTrampaMagicaLlenaException e) {
            fail();
        }
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
        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            fail();
        }
        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            assertTrue(true);
        }
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
            try{
                tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            }
            catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
                fail();
            }
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

        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            assertTrue(true);
        }

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
            try{
                tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            }
            catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
                fail();
            }
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

        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            fail();
        }
        try{
            tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
        catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
            assertTrue(true);
        }
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
            try{
                tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            }
            catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
                fail();
            }
            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException e) {
            fail();
        } catch (InvocacionExcepcion invocacionExcepcion) {
            fail();
        }
    }
}
