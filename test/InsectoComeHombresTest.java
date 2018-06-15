import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class InsectoComeHombresTest {
        @Test
        public void InsectoComeHombresAtaca() {
            HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

            EfectoInsectoComeHombres efectoInsectoComeHombres = new EfectoInsectoComeHombres();
            efectoInsectoComeHombres.utilizarSobre(huevoMonstruoso);

            assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));
        }

        @Test
        public void InsectoComeHombresEsAtacado() {
            InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
            AgujeroNegro agujeroNegro = new AgujeroNegro();
            InsectoComeHombres.atacar(agujeroNegro);

            assertTrue(new Cementerio().equals(agujeroNegro.getUbicacion()));
        }
}
