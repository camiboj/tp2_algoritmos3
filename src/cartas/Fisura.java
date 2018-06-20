package cartas;

import jugador.Jugador;
import tablero.Tablero;

public class Fisura extends CartaMagica {
    Tablero tablero;
    Jugador jugador;

    public Fisura(Tablero unTablero, Jugador unJugador) {
        super("Fisura");
        tablero = unTablero;
        jugador = unJugador;
    }

    public void activarEfecto(){
        tablero.eliminarMonstruoDebil(jugador);
    }

}
