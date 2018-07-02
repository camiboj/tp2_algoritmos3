package modelo.efectos;

import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.jugador.Jugador;
import modelo.jugador.Punto;
import modelo.tablero.Tablero;

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
