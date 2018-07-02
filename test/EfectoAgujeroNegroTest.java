import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlasDeLaLlamaPerversa;
import modelo.cartas.cartasMonstruo.cartasBasicas.AlcanzadorDeGarra;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.efectos.EfectoAgujeroNegro;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.jugador.Punto;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;

import static junit.framework.TestCase.assertTrue;

public class EfectoAgujeroNegroTest {

    @Test
    public void AgujeroNegroMataMonstruos() throws VictoriaException {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso carta1 = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocada1 = new InvocacionCartaMonstruoGenerica(carta1, null); // No requiere sacrificios
        cartaInvocada1.invocar();
        carta1.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocada1,jugador1);
        AlasDeLaLlamaPerversa carta2 = new AlasDeLaLlamaPerversa();
        InvocacionCartaMonstruoGenerica cartaInvocada2 = new InvocacionCartaMonstruoGenerica(carta2, null); // No requiere sacrificios
        cartaInvocada2.invocar();
        carta2.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocada2,jugador1);

        AlcanzadorDeGarra carta3 = new AlcanzadorDeGarra();
        InvocacionCartaMonstruoGenerica cartaInvocada3 = new InvocacionCartaMonstruoGenerica(carta3, null); // No requiere sacrificios
        cartaInvocada3.invocar();
        carta3.colocarEnModoDeDefensa();
        tablero.colocarZonaMonstruo(cartaInvocada3,jugador2);
        AgujeroNegro agujeroNegro = new AgujeroNegro(tablero);
        InvocacionDefault invocacionAgujeroNegro = new InvocacionDefault(agujeroNegro);
        tablero.colocarZonaTrampaMagica(invocacionAgujeroNegro, jugador1);
        try {
            agujeroNegro.colocarBocaArriba();
        } catch (VictoriaException e) {
            //no deberia ocurrir en este test
            assertTrue(false);
        }
        assertTrue(tablero.noTieneCartasMonstruo());

        Cementerio cementerio1 = tablero.mostrarCementerio(jugador1);
        Cementerio cementerio2 = tablero.mostrarCementerio(jugador2);

        assertTrue(true);
        assertTrue(cementerio1.existe(carta1) && cementerio1.existe(carta2));
        assertTrue(cementerio2.existe(carta3));
        assertTrue(jugador1.obtenerPuntos().equals(new Punto(8000)) &&
                jugador2.obtenerPuntos().equals(new Punto(8000)));
    }

    @Test
    public void EfectoAgujeroNegroTest(){

        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

        EfectoAgujeroNegro efectoAgujeroNegro = new EfectoAgujeroNegro();
        efectoAgujeroNegro.utilizarSobre(huevoMonstruoso);
        assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));

    }


}