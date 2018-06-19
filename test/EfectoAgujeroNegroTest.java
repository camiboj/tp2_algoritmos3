import cartas.*;
import efectos.EfectoAgujeroNegro;
import jugador.Jugador;
import jugador.Punto;
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
        InvocacionDefault cartaInvocada1 = new InvocacionDefault(carta1); // No requiere sacrificios
        cartaInvocada1.invocar();
        carta1.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocada1,jugador1);
        AlasDeLaLlamaPerversa carta2 = new AlasDeLaLlamaPerversa();
        InvocacionDefault cartaInvocada2 = new InvocacionDefault(carta2); // No requiere sacrificios
        cartaInvocada2.invocar();
        carta2.colocarEnModoDeAtaque();
        tablero.colocarZonaMonstruo(cartaInvocada2,jugador1);

        AlcanzadorDeGarra carta3 = new AlcanzadorDeGarra();
        InvocacionDefault cartaInvocada3 = new InvocacionDefault(carta3); // No requiere sacrificios
        cartaInvocada3.invocar();
        carta3.colocarEnModoDeDefensa();
        tablero.colocarZonaMonstruo(cartaInvocada3,jugador2);
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        InvocacionDefault invocacionAgujeroNegro = new InvocacionDefault(agujeroNegro);
        tablero.colocarZonaTrampaMagica(invocacionAgujeroNegro,jugador2); //Se coloca boca arriba por Test11
        agujeroNegro.activarEfecto(tablero);
        assertTrue(tablero.noTieneCartasMonstruo());
        Cementerio cementerio1 = tablero.mostrarCementerio(jugador1);
        Cementerio cementerio2 = tablero.mostrarCementerio(jugador2);
        assertTrue(true);
        assertTrue(cementerio1.existe(carta1) && cementerio1.existe(carta2));
        assertTrue(cementerio2.existe(carta3));
        assertTrue(jugador1.obtenerPuntos().equals(new Punto(8000)) &&
                jugador2.obtenerPuntos().equals(new Punto(8000)));
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