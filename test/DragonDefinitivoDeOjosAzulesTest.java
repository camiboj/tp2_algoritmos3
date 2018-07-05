import modelo.Fase.Fase;
import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.cartasBasicas.DragonBlancoDeOjosAzules;
import modelo.cartas.cartasMonstruo.DragonDefinitivoDeOjosAzules;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaDragonDefinitivoOjosAzules;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

public class DragonDefinitivoDeOjosAzulesTest {


    @Test
    public void InvocacionDragonDefinitivoDeOjosAzules() throws VictoriaException {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        ZonaMonstruo zonaMonstruoJugador = tablero.mostrarZonaMonstruo(jugador1);
        Cementerio cementerioJugador = tablero.mostrarCementerio(jugador1);


        List<DragonBlancoDeOjosAzules> dragonesSacrificados = new ArrayList<>();

        DragonBlancoDeOjosAzules dragon1 = new DragonBlancoDeOjosAzules();
        DragonBlancoDeOjosAzules dragon2 = new DragonBlancoDeOjosAzules();
        DragonBlancoDeOjosAzules dragon3 = new DragonBlancoDeOjosAzules();

        dragonesSacrificados.add(dragon3);
        dragonesSacrificados.add(dragon1);
        dragonesSacrificados.add(dragon2);

        try {
            List <CartaMonstruo> lista1 = creaListaHuevos(tablero, jugador1);
            FasePreparacion fasePreparacion1 = new FasePreparacion();
            InvocacionCartaMonstruoGenerica invocacion1 = new InvocacionCartaMonstruoGenerica(dragon1, lista1,
                fasePreparacion1);
            tablero.colocarZonaMonstruo(invocacion1,jugador1);

            List <CartaMonstruo> lista2 = creaListaHuevos(tablero, jugador1);
            FasePreparacion fasePreparacion2 = new FasePreparacion();
            InvocacionCartaMonstruoGenerica invocacion2 = new InvocacionCartaMonstruoGenerica(dragon2, lista2,
                fasePreparacion2);
            tablero.colocarZonaMonstruo(invocacion2,jugador1);

            List <CartaMonstruo> lista3 = creaListaHuevos(tablero, jugador1);
            FasePreparacion fasePreparacion3 = new FasePreparacion();
            InvocacionCartaMonstruoGenerica invocacion3 = new InvocacionCartaMonstruoGenerica(dragon3, lista3,
                fasePreparacion3);
            tablero.colocarZonaMonstruo(invocacion3,jugador1);

            assertTrue(zonaMonstruoJugador.existe(dragon1) && zonaMonstruoJugador.existe(dragon2)
                  && zonaMonstruoJugador.existe(dragon3));

            FasePreparacion fasePreparacionDragon = new FasePreparacion();
            DragonDefinitivoDeOjosAzules unDragonDefinitivo = new DragonDefinitivoDeOjosAzules();
            InvocacionCartaDragonDefinitivoOjosAzules invocacion = new InvocacionCartaDragonDefinitivoOjosAzules(unDragonDefinitivo,
                    dragonesSacrificados, fasePreparacionDragon);
            tablero.colocarZonaMonstruo(invocacion,jugador1);

            assertTrue(cementerioJugador.existe(dragon1) && cementerioJugador.existe(dragon2) &&
                    cementerioJugador.existe(dragon3));
            assertFalse(zonaMonstruoJugador.existe(dragon1) && cementerioJugador.existe(dragon2) &&
                    cementerioJugador.existe(dragon3));

            //Se puede colocar la carta en el campo y no esta en el cementerio
            assertTrue(zonaMonstruoJugador.existe(unDragonDefinitivo));
            assertFalse(cementerioJugador.existe(unDragonDefinitivo));

        }
        catch (ZonaMonstruoLlenaException e) {
            assertTrue(true);
        }
        catch (InvocacionExcepcion e) {
            fail();
        }

    }

    private List<CartaMonstruo> creaListaHuevos(Tablero tablero, Jugador jugador1) {
        HuevoMonstruoso huevoMonstruoso1 = new HuevoMonstruoso();
        HuevoMonstruoso huevoMonstruoso2 = new HuevoMonstruoso();

        List<CartaMonstruo> huevos = new ArrayList<>();

        FasePreparacion fasePreparacionHuevo1 = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso1 = new InvocacionCartaMonstruoGenerica(huevoMonstruoso1,
                fasePreparacionHuevo1);

        FasePreparacion fasePreparacionHuevo2 = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso2 = new InvocacionCartaMonstruoGenerica(huevoMonstruoso2,
                fasePreparacionHuevo2);

        try {
            tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso1, jugador1);
            tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso2, jugador1);

            huevos.add(huevoMonstruoso1);
            huevos.add(huevoMonstruoso2);
            return huevos;

        } catch (ZonaMonstruoLlenaException e) {
            return null;
        } catch (InvocacionExcepcion e) {
            return null;
        }
    }

}
