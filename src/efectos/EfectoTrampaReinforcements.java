package efectos;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import jugador.Punto;
import tablero.Tablero;

public class EfectoTrampaReinforcements implements EfectoTrampa {


    @Override
    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo monstruoDefensor, Jugador jugadorDefensor, Carta cartaJugada, Tablero tablero) {

        Punto puntosAtaqueAdicionales = new Punto(500);
        monstruoDefensor.aumentarAtaque(puntosAtaqueAdicionales);
    }

    @Override
    public boolean interrumpeAtaque() {
        return false;
    }
}
