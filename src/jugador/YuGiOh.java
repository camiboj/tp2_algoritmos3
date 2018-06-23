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
        boolean sinPuntos = (jugador1.sinPuntos() || jugador2.sinPuntos());
        boolean sinMazo = (jugador1.sinMazo() || jugador2.sinMazo());
        return sinPuntos || sinMazo;
    }

    public Jugador obtenerJugador1() { return jugador1; }

    public Jugador obtenerJugador2() { return jugador2; }

}
