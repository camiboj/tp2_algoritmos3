package efectos;
import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;

public class EfectoTrampaCilindroMagico implements EfectoTrampa {

    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo monstruoDefensor, Jugador jugadorDefensor,  Carta cartaJugada) throws InterrumpirAtaqueException {
        jugadorAtacante.restarPuntos(cartaAtacante.obtenerPuntosAtaque());
        throw new InterrumpirAtaqueException(cartaJugada, jugadorDefensor);
    }
}
