import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AgujeroNegroTest {

    @Test
    public void AgujeroNegroTest(){
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();

        EfectoAgujeroNegro efectoAgujeroNegro = new EfectoAgujeroNegro();
        efectoAgujeroNegro.utilizarSobre(huevoMonstruoso);
        assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));

    }

    @Test
    public void AgujeroNegroAtaca() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        agujeroNegro.atacar(huevoMonstruoso);

        assertTrue(new Cementerio().equals(huevoMonstruoso.getUbicacion()));

    }
     @Test
    public void MonstruEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeAtaque();
        assertTrue(huevoMonstruoso.modo().equals(new ModoDeAtaque()));
        
    }
    @Test
    public void MonstruEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeDefensa();
        assertTrue(huevoMonstruoso.modo().equals(new ModoDeDefensa()));
        
    }
    
}

