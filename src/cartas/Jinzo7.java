package cartas;

import estadosDeCartas.Modo;
import jugador.Jugador;
import jugador.Punto;
import tablero.Tablero;

public class Jinzo7 extends CartaMonstruoConEfecto {

    public Jinzo7 (Tablero unTablero, Jugador unJugador) {
        super("Jinzo7", 500, 400, 2, unTablero, unJugador);
    }

    public void activarEfecto() {
        tablero.restarPuntosAOponente(jugador, this.puntosAtaque);
    }
}
