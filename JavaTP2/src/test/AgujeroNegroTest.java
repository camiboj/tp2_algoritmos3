package test;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import cartas.Carta;
import cartas.CreadoraDeCartas;
import cartas.HuevoMonstruoso;
import efectos.AgujeroNegro;
import efectos.EfectoAgujeroNegro;
import estadosDeCartas.BocaAbajo;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import jugador.Jugador;
import tablero.Cementerio;
import tablero.LadoDelCampo;
import tablero.Tablero;

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
    public void MonstruoEnModoDeAtaque() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeAtaque();
        assertTrue(huevoMonstruoso.modo().equals(new ModoDeAtaque()));
        
    }
    @Test
    public void MonstruoEnModoDeDefensa() {
        HuevoMonstruoso huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.invocar();
        huevoMonstruoso.modoDeDefensa();
        assertTrue(huevoMonstruoso.modo().equals(new ModoDeDefensa()));
        
    }
    
    @Test
    public void ColocarCartaMagicaBocaAbajo(){
    	CreadoraDeCartas manager= new CreadoraDeCartas();
        Carta cualquierCarta= manager.crearCarta("Agujero Negro");
        cualquierCarta.colocarBocaAbajo();
        assertTrue(cualquierCarta.getEstado().equals(new BocaAbajo()) );
    }
    
    @Test
    public void CrearTablero(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero= new Tablero(jugador1, jugador2);
        assertTrue(tablero.get(jugador1).equals(new LadoDelCampo()) );
        assertTrue(tablero.get(jugador2).equals(new LadoDelCampo()) );
    }
    
    public void ColocarCasillerosEnTablero() {
    	
    		
    }
}

