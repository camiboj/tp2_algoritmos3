import jugador.Mazo;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class GeneradorDeMazoTest {
    @Test
    public void generarMazoDeCartasStandar(){
        Mazo mazoDeJugador1= new Mazo();
        assertTrue(mazoDeJugador1.obtenerCantidad()==40);
    }
    @Test
    public void importarMazoDeCartasPersonalizado(){
        Mazo mazoDeJugador1= new Mazo("jugadorPersonalizado");
        assertTrue(mazoDeJugador1.obtenerCantidad()>0);
    }

}
