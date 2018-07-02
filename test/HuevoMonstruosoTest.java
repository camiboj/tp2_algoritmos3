import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.estadosDeCartas.ModoDeAtaque;
import modelo.estadosDeCartas.ModoDeDefensa;
import modelo.jugador.Punto;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class HuevoMonstruosoTest {

    @Test
    public void MonstruoEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocada = new InvocacionCartaMonstruoGenerica(huevoMonstruoso); // No requiere sacrificios
        cartaInvocada.invocar();
        huevoMonstruoso.colocarEnModoDeAtaque();
        Punto unPunto = new Punto(400);
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeAtaque(unPunto)));
    }

    @Test
    public void MonstruoEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        InvocacionCartaMonstruoGenerica cartaInvocada = new InvocacionCartaMonstruoGenerica(huevoMonstruoso); // No requiere sacrificios
        cartaInvocada.invocar();
        huevoMonstruoso.colocarEnModoDeDefensa();
        Punto unPunto = new Punto(400);
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeDefensa(unPunto)));
    }
}