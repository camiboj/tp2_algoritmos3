package efectos;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import jugador.Punto;
import tablero.InterrumpirAtaqueException;

public class EfectoTrampaReinforcements implements EfectoTrampa {
    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo monstruoDefensor,
                                    Jugador jugadorDefensor, Carta cartaJugada) throws InterrumpirAtaqueException {

        Punto puntosAtaqueAdicionales = new Punto(500);
        monstruoDefensor.aumentarAtaque(puntosAtaqueAdicionales);
        throw new InterrumpirAtaqueException(cartaJugada, jugadorDefensor);
    }
}
