import cartas.cartasMonstruo.cartasBasicas.AlcanzadorDeGarra;
import cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import cartas.cartasTrampa.CartaTrampa;
import cartas.cartasTrampa.Reinforcements;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
import cartas.invocacion.InvocacionDefault;
import excepciones.VictoriaException;
import jugador.Jugador;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;
import tablero.ZonaTrampaMagica;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ReinforcementsTest {

    @Test
    public void ReinforcementsTieneElEfectoEsperado() throws VictoriaException {
        //assertTrue(true);


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
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora); // No requiere sacrificios
        tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);

        //Creo alcanzador de garra y lo pongo en el tablero
        AlcanzadorDeGarra cartaAtacante = new AlcanzadorDeGarra(); //puntos ataque = 1000
        cartaAtacante.colocarEnModoDeAtaque();

        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante); // No requiere sacrificios
        tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);

        //Ataca el monstruo atacante al defensor
        tablero.atacarDosMonstruos(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);

        //La carta atacante por el efecto Reinforcements está en el cementerio
        Cementerio cementerioAtacante = tablero.mostrarCementerio(jugadorAtacante);
        ZonaMonstruo zonaMonstruoAtacante = tablero.mostrarZonaMonstruo(jugadorAtacante);
        assertTrue(cementerioAtacante.existe(cartaAtacante));
        assertFalse(zonaMonstruoAtacante.existe(cartaAtacante));

        //La carta reinforcements esta en el cementerio porque ya ataco
        Cementerio cementerioReinforcements = tablero.mostrarCementerio(jugadorDefensor);
        ZonaTrampaMagica zonaTrampaMagica = tablero.mostrarZonaTrampaMagica(jugadorDefensor);

        assertTrue(cementerioReinforcements.existe(reinforcements));
        assertFalse(zonaTrampaMagica.existe(reinforcements));

        //El jugador atacante perdio 100 puntos de vida y el otro esta intacto
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero()== 8000-100);
    }
}
