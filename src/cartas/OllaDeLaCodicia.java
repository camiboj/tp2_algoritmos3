package cartas;

import jugador.Jugador;
import tablero.Tablero;

 public class OllaDeLaCodicia extends CartaMagica {
     Tablero tablero;
     Jugador jugador;

    public OllaDeLaCodicia(Tablero unTablero, Jugador unJugador) {
        super("Olla De La Codicia");
        tablero = unTablero;
        jugador = unJugador;
    }

    public void activarEfecto() {
        jugador.agarraCartas(2);
    }
}
