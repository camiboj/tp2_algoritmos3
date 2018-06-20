package cartas;

import jugador.Jugador;
import jugador.Punto;
import tablero.Tablero;

public abstract class CartaMonstruoConEfecto extends CartaMonstruo {
    Tablero tablero;
    Jugador jugador;

    public CartaMonstruoConEfecto(String unNombredeCarta, int unosPuntosAtaque, int unosPuntosDefensa, int cantidadEstrellas,
                                  Tablero unTablero, Jugador unJugador) {
        super(unNombredeCarta, unosPuntosAtaque, unosPuntosDefensa, cantidadEstrellas);
        jugador = unJugador;
        tablero = unTablero;
    }

    public abstract void activarEfecto();
}
