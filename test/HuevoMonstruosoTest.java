import cartas.HuevoMonstruoso;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class HuevoMonstruosoTest {

    @Test
    public void MonstruoEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeAtaque();
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeAtaque()));
    }

    @Test
    public void MonstruoEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeDefensa();
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeDefensa()));
    }

}
