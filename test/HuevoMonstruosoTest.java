import modelo.Fase.Fase;
import modelo.Fase.FasePreparacion;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.estadosDeCartas.ModoDeAtaque;
import modelo.estadosDeCartas.ModoDeDefensa;
import modelo.excepciones.InvocacionExcepcion;
import modelo.jugador.Punto;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class HuevoMonstruosoTest {

    @Test
    public void MonstruoEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

        FasePreparacion fasePreparacionInvocada = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocada = new InvocacionCartaMonstruoGenerica(huevoMonstruoso,
                fasePreparacionInvocada); // No requiere sacrificios
        try {
            cartaInvocada.invocar();
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }
        huevoMonstruoso.colocarEnModoDeAtaque();
        Punto unPunto = new Punto(400);
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeAtaque(unPunto)));
    }

    @Test
    public void MonstruoEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        FasePreparacion fasePreparacionInvocada = new FasePreparacion();
        InvocacionCartaMonstruoGenerica cartaInvocada = new InvocacionCartaMonstruoGenerica(huevoMonstruoso,
                fasePreparacionInvocada); // No requiere sacrificios
        try {
            cartaInvocada.invocar();
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }
        huevoMonstruoso.colocarEnModoDeDefensa();
        Punto unPunto = new Punto(400);
        assertTrue(huevoMonstruoso.obtenerModo().equals(new ModoDeDefensa(unPunto)));
    }
}