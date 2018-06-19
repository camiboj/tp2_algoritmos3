import cartas.*;
import jugador.Jugador;
import org.junit.Test;
import tablero.Cementerio;
import tablero.Tablero;
import tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MonstruoSacrificioTest {

    @Test
    public void invocarMonstruo5EstrellasRequiere1Sacrificio(){
        Aitsu cartaCausanteSacrificios = new Aitsu();
        HuevoMonstruoso cartaSacrificada = new HuevoMonstruoso();
        List<CartaMonstruo> cartasASacrificar = new ArrayList<>();
        cartasASacrificar.add(cartaSacrificada);

        InvocacionCartaMonstruo invocacionCausanteSacrificios =
                new InvocacionCartaMonstruo(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionDefault invocacionHuevoMonstruoso = new InvocacionDefault(cartaSacrificada);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
        tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);

        //La carta sacrificada esta en el cementerio y fue retirada del campo
        assertTrue(cementerio.existe(cartaSacrificada));
        assertFalse(zonaMonstruo.existe(cartaSacrificada));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }

    @Test
    public void invocarMonstruo5EstrellasRequiere1SacrificioYElige (){
        Aitsu cartaCausanteSacrificios = new Aitsu();
        HuevoMonstruoso cartaSacrificada = new HuevoMonstruoso();
        List<CartaMonstruo> cartasASacrificar = new ArrayList<>();
        cartasASacrificar.add(cartaSacrificada);
        AlasDeLaLlamaPerversa cartaNoSacrificada = new AlasDeLaLlamaPerversa();

        InvocacionCartaMonstruo invocacionCausanteSacrificios =
                new InvocacionCartaMonstruo(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionDefault invocacionHuevoMonstruoso = new InvocacionDefault(cartaSacrificada);
        InvocacionDefault invocacionAlasDeLaLLamaPerversa = new InvocacionDefault(cartaNoSacrificada);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
        tablero.colocarZonaMonstruo(invocacionAlasDeLaLLamaPerversa, jugador1);
        tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);

        //La carta sacrificada esta en el cementerio y fue retirada del campo
        assertTrue(cementerio.existe(cartaSacrificada));
        assertFalse(zonaMonstruo.existe(cartaSacrificada));

        //La carta no sacrificada no esta en el cementerio y no fue retirada del campo
        assertFalse(cementerio.existe(cartaNoSacrificada));
        assertTrue(zonaMonstruo.existe(cartaNoSacrificada));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }

    @Test
    public void invocarMonstruo6EstrellasRequiere1Sacrificio () {
        BestiaDeTalwar cartaCausanteSacrificios = new BestiaDeTalwar();
        HuevoMonstruoso cartaSacrificada = new HuevoMonstruoso();
        List <CartaMonstruo> cartasASacrificar = new ArrayList <>();
        cartasASacrificar.add(cartaSacrificada);

        InvocacionCartaMonstruo invocacionCausanteSacrificios =
                new InvocacionCartaMonstruo(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionDefault invocacionHuevoMonstruoso = new InvocacionDefault(cartaSacrificada);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
        tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);

        //La carta sacrificada esta en el cementerio y fue retirada del campo
        assertTrue(cementerio.existe(cartaSacrificada));
        assertFalse(zonaMonstruo.existe(cartaSacrificada));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }

    @Test
    public void invocarMonstruo7EstrellasRequiere2Sacrificios () {assertTrue(true);}
}
