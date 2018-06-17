import cartas.AlasDeLaLlamaPerversa;
import cartas.HuevoMonstruoso;
import org.junit.Test;
import tablero.Casillero;
import tablero.Cementerio;

import static junit.framework.TestCase.assertTrue;

public class AlasDeLaLlamaPerversaAtacaAHuevoMonstruosoTest {

    @Test
    public void testAlasDeLaLlamaPerversaAtacaAHuevoMonstruosoYLoMata() {
        AlasDeLaLlamaPerversa alasDeLaLlamaPerversa = new AlasDeLaLlamaPerversa();
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

        huevoMonstruoso.invocar();
        alasDeLaLlamaPerversa.invocar();

        huevoMonstruoso.modoDeAtaque();
        alasDeLaLlamaPerversa.modoDeAtaque();

        alasDeLaLlamaPerversa.atacar(huevoMonstruoso);

        assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));
        assertTrue(new Casillero().equals(alasDeLaLlamaPerversa.getUbicacion()));
    }

}
