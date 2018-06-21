package tablero;
import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.Invocacion;
import cartas.Trampa;
import jugador.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZonaTrampaMagica implements Zona {
    private static final int CANT_CASILLEROS = 5;
    private List<Casillero> casilleros;

    public ZonaTrampaMagica() {
        casilleros = new ArrayList<>();
        for (int i = 0; i < CANT_CASILLEROS; i++) casilleros.add(new Casillero());
    }

    public void eliminarCarta(Carta carta) {

        for (int i = 0; i < 5; i += 1) {
            if (casilleros.get(i).comparar(carta)) {
                casilleros.get(i).borrarCarta();
            }
        }
    }

    public boolean colocarCarta(Invocacion invocacion) {
        List<Casillero> vacios = casilleros.stream().filter(casillero -> casillero.estaVacio()).collect(Collectors.toList());
        if (vacios.size() == 0) return false; //No hay espacio
        try {
            Carta carta = invocacion.invocar();
            vacios.get(0).colocarCarta(carta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean estaVacia() {
        for (int i = 0; i<5; i+=1){
            if(!casilleros.get(i).estaVacio()){
                return false;
            }
        }
        return true;
    }
    public boolean existe(Carta unaCarta) {
        for (int i = 0; i < 5; i += 1) {
            Casillero casillero = casilleros.get(i);
            if (casillero.comparar(unaCarta)) {
                return true;
            }
        }
        return false;
    }
    public void activar(Carta trampa, CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo cartaDefensora, Jugador jugadorDefensor) throws InterrumpirAtaqueException{
        if(existe(trampa)) {
            Trampa trampaAActivar=(Trampa) trampa;
            trampaAActivar.activarAnteUnAtaque(cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
        }
    }

    public List<Trampa> obtenerCartasTrampas() {
        List<Trampa> resultado = new ArrayList<>();
        for (int i = 0; i < CANT_CASILLEROS; i++) {
            Casillero casillero = casilleros.get(i);
            if (! casillero.estaVacio() &&( casillero.mostrarCarta() instanceof Trampa ) ) resultado.add((Trampa) casillero.mostrarCarta());
        }
        return resultado;
    }
}
