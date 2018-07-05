import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.*;
import modelo.cartas.cartasMonstruo.cartasBasicas.*;
import modelo.cartas.invocacion.InvocacionCartaMonstruoGenerica;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import org.junit.Test;
import modelo.tablero.Cementerio;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MonstruoSacrificioTest {

    @Test
    public void invocarMonstruo5EstrellasRequiere1Sacrificio() throws VictoriaException {
        Aitsu cartaCausanteSacrificios = new Aitsu();
        HuevoMonstruoso cartaSacrificada = new HuevoMonstruoso();
        List<CartaMonstruo> cartasASacrificar = new ArrayList<>();
        cartasASacrificar.add(cartaSacrificada);

        FasePreparacion fasePreparacionCausanteSacrificios = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar,
                        fasePreparacionCausanteSacrificios);

        FasePreparacion fasePreparacionHuevoMonstruoso = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada,
                fasePreparacionHuevoMonstruoso);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        try {
            tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }
        try {
            tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);
        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        //La carta sacrificada esta en el cementerio y fue retirada del campo
        assertFalse(zonaMonstruo.existe(cartaSacrificada));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }

    @Test
    public void invocarMonstruo5EstrellasRequiere1SacrificioYElige () throws VictoriaException {

        HuevoMonstruoso cartaSacrificada = new HuevoMonstruoso();
        FasePreparacion fasePreparacionSacrificada = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada,
                fasePreparacionSacrificada);
        List<CartaMonstruo> cartasASacrificar = new ArrayList<>();
        cartasASacrificar.add(cartaSacrificada);

        Aitsu cartaCausanteSacrificios = new Aitsu();
        FasePreparacion fasePreparacionSacrificios = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar, fasePreparacionSacrificios);

        AlasDeLaLlamaPerversa cartaNoSacrificada = new AlasDeLaLlamaPerversa();
        FasePreparacion fasePreparacionNoSacrificada = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionAlasDeLaLLamaPerversa = new InvocacionCartaMonstruoGenerica
                (cartaNoSacrificada, fasePreparacionNoSacrificada);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        try {
            tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
            tablero.colocarZonaMonstruo(invocacionAlasDeLaLLamaPerversa, jugador1);
            tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);

        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        //La carta sacrificada esta en el cementerio y fue retirada del campo
        assertFalse(zonaMonstruo.existe(cartaSacrificada));

        //La carta no sacrificada no esta en el cementerio y no fue retirada del campo
        assertTrue(zonaMonstruo.existe(cartaNoSacrificada));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }

    @Test
    public void invocarMonstruo6EstrellasRequiere1Sacrificio () throws VictoriaException {

        HuevoMonstruoso cartaSacrificada = new HuevoMonstruoso();
        List <CartaMonstruo> cartasASacrificar = new ArrayList <>();
        cartasASacrificar.add(cartaSacrificada);
        FasePreparacion fasePreparacionSacrificada = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada,
                fasePreparacionSacrificada);

        BestiaDeTalwar cartaCausanteSacrificios = new BestiaDeTalwar();
        FasePreparacion fasePreparacionCausanteSacrificios = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar, fasePreparacionCausanteSacrificios);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        try {
            tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
            tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);

        } catch (ZonaMonstruoLlenaException e) {
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        //La carta sacrificada esta en el cementerio y fue retirada del campo
        assertFalse(zonaMonstruo.existe(cartaSacrificada));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }

    @Test
    public void invocarMonstruo7EstrellasRequiere2Sacrificios () throws VictoriaException {
        ArañaLanzadora cartaCausanteSacrificios = new ArañaLanzadora();
        HuevoMonstruoso cartaSacrificada1 = new HuevoMonstruoso();
        AlasDeLaLlamaPerversa cartaSacrificada2 = new AlasDeLaLlamaPerversa();
        List <CartaMonstruo> cartasASacrificar = new ArrayList <>();
        cartasASacrificar.add(cartaSacrificada1);
        cartasASacrificar.add(cartaSacrificada2);

        FasePreparacion fasePreparacionCausanteSacrificios = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionCausanteSacrificios =
                new InvocacionCartaMonstruoGenerica(cartaCausanteSacrificios, cartasASacrificar, fasePreparacionCausanteSacrificios);

        FasePreparacion fasePreparacionHuevoMonstruoso = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionHuevoMonstruoso = new InvocacionCartaMonstruoGenerica(cartaSacrificada1,
                fasePreparacionHuevoMonstruoso);

        FasePreparacion fasePreparacionAlas = new FasePreparacion();
        InvocacionCartaMonstruoGenerica invocacionAlasDeLaLlamaPerversa = new InvocacionCartaMonstruoGenerica(cartaSacrificada2,
                fasePreparacionAlas);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tablero = new Tablero(jugador1, jugador2);
        Cementerio cementerio = tablero.mostrarCementerio(jugador1);
        ZonaMonstruo zonaMonstruo = tablero.mostrarZonaMonstruo(jugador1);

        try {
            tablero.colocarZonaMonstruo(invocacionAlasDeLaLlamaPerversa, jugador1);
            tablero.colocarZonaMonstruo(invocacionHuevoMonstruoso, jugador1);
            tablero.colocarZonaMonstruo(invocacionCausanteSacrificios, jugador1);
        } catch (ZonaMonstruoLlenaException e) {
            e.printStackTrace();
        } catch (InvocacionExcepcion invocacionExcepcion) {
        }

        //Las cartas sacrificadas esta en el cementerio y fueron retiradas del campo
        assertFalse(zonaMonstruo.existe(cartaSacrificada1));
        assertFalse(zonaMonstruo.existe(cartaSacrificada2));

        //Se puede colocar la carta en el campo
        assertTrue(zonaMonstruo.existe(cartaCausanteSacrificios));
    }
}
