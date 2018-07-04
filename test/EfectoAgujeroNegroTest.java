import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlcanzadorDeGarra;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.efectos.EfectoAgujeroNegro;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import modelo.jugador.Punto;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class EfectoAgujeroNegroTest {

    @Test
    public void AgujeroNegroMataMonstruos() throws VictoriaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);

        FasePreparacion fasePreparacion1 = new FasePreparacion();
        HuevoMonstruoso carta1 = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocada1 = new InvocacionCartaMonstruoGenerica(carta1, fasePreparacion1); // No requiere sacrificios

        carta1.colocarEnModoDeAtaque();

        AlasDeLaLlamaPerversa carta2 = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacion2 = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocada2 = new InvocacionCartaMonstruoGenerica(carta2, fasePreparacion2); // No requiere sacrificios

        carta2.colocarEnModoDeAtaque();

        AlcanzadorDeGarra carta3 = new AlcanzadorDeGarra();
        FasePreparacion fasePreparacion3 = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocada3 = new InvocacionCartaMonstruoGenerica(carta3, fasePreparacion3); // No requiere sacrificios

        carta3.colocarEnModoDeDefensa();
        try {
            tablero.colocarZonaMonstruo(cartaInvocada1,jugador1);
            tablero.colocarZonaMonstruo(cartaInvocada2,jugador1);
            tablero.colocarZonaMonstruo(cartaInvocada3,jugador2);
            AgujeroNegro agujeroNegro = new AgujeroNegro();
            InvocacionDefault invocacionAgujeroNegro = new InvocacionDefault(agujeroNegro);
            tablero.colocarZonaTrampaMagica(invocacionAgujeroNegro, jugador1);
            agujeroNegro.colocarBocaArriba();
            assertTrue(tablero.noTieneCartasMonstruo());

            Cementerio cementerio1 = tablero.mostrarCementerio(jugador1);
            Cementerio cementerio2 = tablero.mostrarCementerio(jugador2);

            assertTrue(true);
            assertTrue(cementerio1.existe(carta1) && cementerio1.existe(carta2));
            assertTrue(cementerio2.existe(carta3));
            assertTrue(jugador1.obtenerPuntos().equals(new Punto(8000)) &&
                    jugador2.obtenerPuntos().equals(new Punto(8000)));
        } catch (ZonaMonstruoLlenaException | InvocacionExcepcion e) {
            fail();
        }

    }

}