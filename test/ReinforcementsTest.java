import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlcanzadorDeGarra;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.cartasTrampa.CartaTrampa;
import modelo.cartas.cartasTrampa.Reinforcements;
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
import modelo.tablero.ZonaTrampaMagica;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ReinforcementsTest {

    @Test
    public void ReinforcementsTieneElEfectoEsperado() throws VictoriaException, ZonaMonstruoLlenaException {

        //Creación del modelo.tablero
        Jugador jugadorDefensor = new Jugador();
        Jugador jugadorAtacante = new Jugador();
        Tablero tablero = new Tablero(jugadorDefensor, jugadorAtacante);

        //Creo reinforcements y la carta defensora y lo pongo en el modelo.tablero
        CartaTrampa reinforcements = new Reinforcements();
        InvocacionDefault invocacionReinforcements = new InvocacionDefault(reinforcements);
        tablero.colocarZonaTrampaMagica(invocacionReinforcements, jugadorDefensor);
        HuevoMonstruoso cartaDefensora = new HuevoMonstruoso(); //puntosAtaque = 600
        cartaDefensora.colocarEnModoDeAtaque();

        FasePreparacion fasePreparacionCartaDefensora = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaDefensora = new InvocacionCartaMonstruoGenerica(cartaDefensora,
                fasePreparacionCartaDefensora); // No requiere sacrificios
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaDefensora, jugadorDefensor);
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        //Creo alcanzador de garra y lo pongo en el modelo.tablero
        AlcanzadorDeGarra cartaAtacante = new AlcanzadorDeGarra(); //puntos ataque = 1000
        cartaAtacante.colocarEnModoDeAtaque();

        FasePreparacion fasePreparacionCartaAtacante = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocadaAtacante = new InvocacionCartaMonstruoGenerica(cartaAtacante,
                fasePreparacionCartaAtacante); // No requiere sacrificios
        try {
            tablero.colocarZonaMonstruo(cartaInvocadaAtacante, jugadorAtacante);
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

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

        //El modelo.jugador atacante perdio 100 puntos de vida y el otro esta intacto
        assertTrue(jugadorDefensor.obtenerPuntos().obtenerNumero() == 8000);
        assertTrue(jugadorAtacante.obtenerPuntos().obtenerNumero()== 8000-100);
    }
}
