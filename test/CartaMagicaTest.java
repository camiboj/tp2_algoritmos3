import cartas.Carta;
import cartas.CreadoraDeCartas;
import estadosDeCartas.BocaAbajo;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class CartaMagicaTest {
    @Test
    public void ColocarCartaMagicaBocaAbajo(){
        CreadoraDeCartas manager= new CreadoraDeCartas();
        Carta cualquierCarta= manager.crearCarta("Agujero Negro");
        cualquierCarta.colocarBocaAbajo();
        assertTrue(cualquierCarta.getEstado().equals(new BocaAbajo()) );
    }
}
