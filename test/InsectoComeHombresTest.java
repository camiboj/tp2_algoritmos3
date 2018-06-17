import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class InsectoComeHombresTest {
        @Test
        public void EfectoInsectoComeHombres() {
            HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

            EfectoInsectoComeHombres efectoInsectoComeHombres = new EfectoInsectoComeHombres();
            efectoInsectoComeHombres.utilizarSobre(huevoMonstruoso);

            assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));
        }

        @Test
        public void InsectoComeHombresAtaca() {
            InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
            HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
            insectoComeHombres.atacar(huevoMonstruoso);

            assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));
        }
        @Test
        public void InsectoComeHombresEsAtacado() {
            HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
            AgujeroNegro agujeroNegro = new AgujeroNegro();
            huevoMonstruoso.atacar(agujeroNegro);

            assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));
        }
    }
