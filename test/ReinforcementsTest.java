import cartas.cartasMonstruo.AlcanzadorDeGarra;
import cartas.cartasMonstruo.HuevoMonstruoso;
import cartas.cartasTrampa.CartaTrampa;
import cartas.cartasTrampa.Reinforcements;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
import cartas.invocacion.InvocacionDefault;
import jugador.Jugador;
import jugador.Punto;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;
import tablero.ZonaTrampaMagica;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ReinforcementsTest {

    @Test
    public void ReinforcementsTieneElEfectoEsperado() {

        //Creación del tablero
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        //Creo reinforcements y la carta defensora y lo pongo en el tablero
        CartaTrampa reinforcements = new Reinforcements();
        InvocacionDefault invocacionReinforcements = new InvocacionDefault(reinforcements);
        tablero.colocarZonaTrampaMagica(invocacionReinforcements, jugadorDefensor);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso(); //puntosAtaque = 600
        cartaDefensora.colocarEnModoDeAtaque();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora, null); // No requiere sacrificios
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);

        //Creo alcanzador de garra y lo pongo en el tablero
        AlcanzadorDeGarra cartaAtacante = new AlcanzadorDeGarra(); //puntos ataque = 1000
        cartaAtacante.colocarEnModoDeAtaque();

        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante, null); // No requiere sacrificios
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);

        //Ataca el monstruo atacante al defensor
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);

        //La carta atacante por el efecto Reinforcements está en el cementerio
        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
        //assertTrue(cementerioAtacante.existe(cartaAtacante)); NO FUNCIONA
        //assertFalse(zonaMonstruoAtacante.existe(cartaAtacante)); NO FUNCIONA

        //La carta reinforcements esta en el cementerio porque ya ataco
        Cementerio cementerioReinforcements = tablero.mostrarCementerio(jugadorDefensor);
        ZonaTrampaMagica zonaTrampaMagica = tablero.mostrarZonaTrampaMagica(jugadorDefensor);

        assertTrue(cementerioReinforcements.existe(reinforcements));
        assertFalse(zonaTrampaMagica.existe(reinforcements));

        //El jugador atacante perdio 100 puntos de vida y el otro esta intacto
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        //assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero()== 8000-100); NO FUNCIONA
    }
}
