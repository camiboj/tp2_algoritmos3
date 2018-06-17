import cartas.Carta;
import cartas.CreadoraDeCartas;
import cartas.HuevoMonstruoso;
import efectos.AgujeroNegro;
import efectos.EfectoAgujeroNegro;
import estadosDeCartas.BocaAbajo;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import jugador.Jugador;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import tablero.Cementerio;
import tablero.LadoDelCampo;
import tablero.Tablero;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HuevoMonstruosoTest {

    @Test
    public void MonstruoEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeAtaque();
        assertTrue(huevoMonstruoso.modo().equals(new ModoDeAtaque()));

    }
    @Test
    public void MonstruoEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeDefensa();
        assertTrue(huevoMonstruoso.modo().equals(new ModoDeDefensa()));
    }

}
