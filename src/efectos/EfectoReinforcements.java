package efectos;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import jugador.Punto;
import tablero.InterrumpirAtaqueException;

public class EfectoReinforcements implements Efecto {
    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo monstruoDefensor,
                                    Jugador jugadorDefensor, Carta cartaJugada) {

        Punto puntosAtaqueAdicionales = new Punto(500);
        monstruoDefensor.aumentarAtaque(puntosAtaqueAdicionales);
    }
}
