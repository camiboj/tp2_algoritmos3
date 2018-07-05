import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlcanzadorDeGarra;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.*;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;

public class DefensaMonstruoTest {
    @Test
    public void cartaEnModoDefensaEsAtacadaYGana() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa); // No requiere sacrificios

        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        AlasDeLaLlamaPerversa cartaAtacante = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque); // No requiere sacrificios

        cartaDefensora.colocarEnModoDeDefensa();
        cartaAtacante.colocarEnModoDeAtaque();

        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora,jugadorDefensor);
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante,jugadorAtacante);
            try{
                tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
            }
            catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
                fail();
            }

            ZonaMonstruo zonaMonstruoDefensor = tablero.mostrarZonaMonstruo(jugadorDefensor);
            ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
            assertTrue(zonaMonstruoDefensor.existe(cartaDefensora) && zonaMonstruoAtacante.existe(cartaAtacante));
            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

    }

    @Test
    public void cartaEnModoDefensaEsAtacadaYPierdeConPuntosDeSobra() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso();
        FasePreparacion fasePreparacionDefensora = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensora);


        AlcanzadorDeGarra cartaAtacante = new AlcanzadorDeGarra();
        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque); // No requiere sacrificios

        cartaDefensora.colocarEnModoDeDefensa();
        cartaAtacante.colocarEnModoDeAtaque();

        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora,jugadorDefensor);

            tablero.colocarZonaMonstruo(cartaInvocadaAtacante,jugadorAtacante);
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
            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

    }

    @Test
    public void cartaEnModoDefensaEsAtacadaYPierdeConPuntosIguales() throws VictoriaException {
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        HuevoMonstruoso cartaAtacante = new HuevoMonstruoso();
        FasePreparacion fasePreparacionAtaque = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionAtaque);

        AlasDeLaLlamaPerversa cartaDefensora = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionDefensa = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionDefensa);
        cartaDefensora.colocarEnModoDeDefensa();
        cartaAtacante.colocarEnModoDeAtaque();

        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante,jugadorAtacante);
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora,jugadorDefensor);
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
            ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
            assertTrue(zonaMonstruoAtacante.existe(cartaAtacante));

            assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero() == 8000);
            assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

    }
}
