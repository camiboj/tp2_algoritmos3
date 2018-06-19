import cartas.HuevoMonstruoso;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import jugador.Punto;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class HuevoMonstruosoTest {

    @Test
    public void MonstruoEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        //huevoMonstruoso.invocar();
        huevoMonstruoso.colocarEnModoDeAtaque();
        Punto unPunto = new Punto(400);
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeAtaque(unPunto)));
    }

    @Test
    public void MonstruoEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        //huevoMonstruoso.invocar();
        huevoMonstruoso.colocarEnModoDeDefensa();
        Punto unPunto = new Punto(400);
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeDefensa(unPunto)));
    }

}
