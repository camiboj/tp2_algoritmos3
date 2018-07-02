import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.cartasBasicas.DragonBlancoDeOjosAzules;
import modelo.cartas.cartasMonstruo.DragonDefinitivoDeOjosAzules;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaDragonDefinitivoOjosAzules;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DragonDefinitivoDeOjosAzulesTest {


    @Test
    public void InvocacionDragonDefinitivoDeOjosAzules() throws VictoriaException {
        assertTrue(true);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        ZonaMonstruo zonaMonstruoJugador = tablero.mostrarZonaMonstruo(jugador1);
        Cementerio cementerioJugador = tablero.mostrarCementerio(jugador1);

        List <CartaMonstruo> lista1 = creaListaHuevos(tablero, jugador1);
        List <CartaMonstruo> lista2 = creaListaHuevos(tablero, jugador1);
        List <CartaMonstruo> lista3 = creaListaHuevos(tablero, jugador1);

        List<DragonBlancoDeOjosAzules> dragonesSacrificados = new ArrayList<>();
        DragonBlancoDeOjosAzules dragon1 = new DragonBlancoDeOjosAzules();
        DragonBlancoDeOjosAzules dragon2 = new DragonBlancoDeOjosAzules();
        DragonBlancoDeOjosAzules dragon3 = new DragonBlancoDeOjosAzules();
        dragonesSacrificados.add(dragon1);
        dragonesSacrificados.add(dragon2);
        dragonesSacrificados.add(dragon3);
        InvocacionCartaMonstruoGenerica invocacion1 = new InvocacionCartaMonstruoGenerica(dragon1, lista1);
        InvocacionCartaMonstruoGenerica invocacion2 = new InvocacionCartaMonstruoGenerica(dragon2, lista2);
        InvocacionCartaMonstruoGenerica invocacion3 = new InvocacionCartaMonstruoGenerica(dragon3, lista3);

        tablero.colocarZonaMonstruo(invocacion1,jugador1);
        tablero.colocarZonaMonstruo(invocacion2,jugador1);
        tablero.colocarZonaMonstruo(invocacion3,jugador1);

        //Los 3 dragones blancos se colocan correctamente
        assertTrue(zonaMonstruoJugador.existe(dragon1) && zonaMonstruoJugador.existe(dragon2)
               && zonaMonstruoJugador.existe(dragon3));

        DragonDefinitivoDeOjosAzules unDragonDefinitivo = new DragonDefinitivoDeOjosAzules();
        InvocacionCartaDragonDefinitivoOjosAzules invocacion = new InvocacionCartaDragonDefinitivoOjosAzules(unDragonDefinitivo, dragonesSacrificados);
        tablero.colocarZonaMonstruo(invocacion,jugador1);

        //Las modelo.cartas sacrificadas estan en el cementerio y fueron retiradas del campo
        assertTrue(cementerioJugador.existe(dragon1) && cementerioJugador.existe(dragon2) &&
                cementerioJugador.existe(dragon3));
        assertFalse(zonaMonstruoJugador.existe(dragon1) && cementerioJugador.existe(dragon2) &&
                cementerioJugador.existe(dragon3));

        //Se puede colocar la carta en el campo y no esta en el cementerio
        assertTrue(zonaMonstruoJugador.existe(unDragonDefinitivo));
        assertFalse(cementerioJugador.existe(unDragonDefinitivo));
    }

    private List<CartaMonstruo> creaListaHuevos(Tablero tablero, Jugador jugador1) {
        HuevoMonstruoso huevoMonstruoso1 = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso1 = new InvocacionCartaMonstruoGenerica(huevoMonstruoso1, null);
        tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso1, jugador1);

        HuevoMonstruoso huevoMonstruoso2 = new HuevoMonstruoso();

        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso2 = new InvocacionCartaMonstruoGenerica(huevoMonstruoso1, null);
        tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso2, jugador1);

        List<CartaMonstruo> huevos = new ArrayList<>();
        huevos.add(huevoMonstruoso1);
        huevos.add(huevoMonstruoso2);
        return huevos;
    }

}
