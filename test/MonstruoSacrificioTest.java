import cartas.cartasMonstruo.*;
import cartas.invocacion.InvocacionCartaMonstruoGenerica;
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


        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada,
                null);

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

        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada, null);
        InvocacionCartaMonstruoGenerica invocacionAlasDeLaLLamaPerversa = new InvocacionCartaMonstruoGenerica(cartaNoSacrificada, null);

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

        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada, null);

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
    public void invocarMonstruo7EstrellasRequiere2Sacrificios () {
        ArañaLanzadora cartaCausanteSacrificios = new ArañaLanzadora();
        HuevoMonstruoso cartaSacrificada1 = new HuevoMonstruoso();
        AlasDeLaLlamaPerversa cartaSacrificada2 = new AlasDeLaLlamaPerversa();
        List <CartaMonstruo> cartasASacrificar = new ArrayList <>();
        cartasASacrificar.add(cartaSacrificada1);
        cartasASacrificar.add(cartaSacrificada2);

        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar);
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada1, null);
        InvocacionCartaMonstruoGenerica invocacionAlasDeLaLlamaPerversa = new InvocacionCartaMonstruoGenerica(cartaSacrificada2, null);


        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        tablero.colocarZonaMonstruo(invocacionAlasDeLaLlamaPerversa, jugador1);
        tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
        tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);

        //Las cartas sacrificadas esta en el cementerio y fueron retiradas del campo
        assertTrue(cementerio.existe(cartaSacrificada1));
        assertFalse(zonaMonstruo.existe(cartaSacrificada1));
        assertTrue(cementerio.existe(cartaSacrificada2));
        assertFalse(zonaMonstruo.existe(cartaSacrificada2));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }
}
