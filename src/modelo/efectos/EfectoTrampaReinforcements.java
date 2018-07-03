package modelo.efectos;

import modelo.cartas.Carta;
import modelo.jugador.Jugador;
import modelo.jugador.Punto;
import modelo.tablero.Tablero;

public class EfectoTrampaReinforcements implements EfectoTrampa {


    @Override
    public void activarAnteUnAtaque(modelo.cartas.cartasMonstruo.CartaMonstruo cartaAtacante, Jugador jugadorAtacante, modelo.cartas.cartasMonstruo.CartaMonstruo monstruoDefensor, Jugador jugadorDefensor, Carta cartaJugada, Tablero tablero) {

        Punto puntosAtaqueAdicionales = new Punto(500);
        monstruoDefensor.aumentarAtaque(puntosAtaqueAdicionales);
    }

    @Override
    public boolean interrumpeAtaque() {
        return false;
    }
}
