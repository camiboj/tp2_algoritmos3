package jugador;
import tablero.Tablero;

public class YuGiOh {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public YuGiOh() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        tablero = new Tablero(jugador1, jugador2);
    }

    public boolean finDelJuego() {
        return (jugador1.pierde(jugador2.mostrarMano()) && jugador2.gana() ||
                jugador1.gana() && jugador2.pierde(jugador1.mostrarMano()));
    }

    public Jugador obtenerJugador1() { return jugador1; }

    public Jugador obtenerJugador2() { return jugador2; }

    public Tablero mostrarTablero() {
        return tablero;
    }
}
