import cartas.AlasDeLaLlamaPerversa;
import cartas.AlcanzadorDeGarra;
import cartas.HuevoMonstruoso;
import efectos.AgujeroNegro;
import efectos.EfectoAgujeroNegro;
import jugador.Jugador;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;

import static junit.framework.TestCase.assertTrue;

public class EfectoAgujeroNegroTest {

    @Test
    public void AgujeroNegroMataMonstruos(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        HuevoMonstruoso carta1 = new HuevoMonstruoso();
        carta1.invocar();
        carta1.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(carta1,jugador1);

        AlasDeLaLlamaPerversa carta2 = new AlasDeLaLlamaPerversa();
        carta2.invocar();
        carta2.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(carta2,jugador1);

        AlcanzadorDeGarra carta3 = new AlcanzadorDeGarra();
        carta3.invocar();
        carta3.colocarEnModoDeDefensa();
        tablero.colocarZonaMonstruo(carta3,jugador2);

        AgujeroNegro agujeroNegro = new AgujeroNegro();
        tablero.colocarZonaTrampaMagica(agujeroNegro,jugador2); //Se coloca boca arriba por ahora

        agujeroNegro.activarEfecto(tablero);

        assertTrue(tablero.noTieneCartasMonstruo());




    }
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