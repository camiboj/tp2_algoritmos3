import cartas.HuevoMonstruoso;
import efectos.AgujeroNegro;
import efectos.EfectoAgujeroNegro;
import org.junit.Test;
import tablero.Cementerio;
import static junit.framework.TestCase.assertTrue;

public class EfectoAgujeroNegroTest {

    @Test
    public void EfectoAgujeroNegroTest(){
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

        EfectoAgujeroNegro efectoAgujeroNegro = new EfectoAgujeroNegro();
        efectoAgujeroNegro.utilizarSobre(huevoMonstruoso);
        assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));

    }

    @Test
    public void EfectoAgujeroNegroAtaca() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        agujeroNegro.atacar(huevoMonstruoso);

        assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));

    }
}

