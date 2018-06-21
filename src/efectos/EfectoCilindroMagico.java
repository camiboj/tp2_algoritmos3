package efectos;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;

public class EfectoCilindroMagico implements Efecto{

    @Override
    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo monstruoDefensor, Jugador jugadorDefensor,  Carta cartaJugada) throws InterrumpirAtaqueException {
        jugadorDefensor.restarPuntos(cartaAtacante.obtenerPuntosAtaque());
        throw new InterrumpirAtaqueException(cartaJugada, jugadorDefensor);
    }
}
