package tablero;

import cartas.Carta;
import jugador.Jugador;

public class InterrumpirAtaqueException extends Exception {
    Carta CartaUsada;
    Jugador jugadorQueLaJugo;
    //esta excepcion es para evitar la resolucion del ataque cuando algo interrumpe la ejecucion de un ataque
    public  InterrumpirAtaqueException(Carta cartaActivada, Jugador jugadorQueLaActivo){
        CartaUsada=cartaActivada;
        jugadorQueLaJugo=jugadorQueLaActivo;
    }

    public Carta obtenerCartaUsada() {
        return CartaUsada;
    }

    public Jugador obtenerJugadorQueLaJugo() {
        return jugadorQueLaJugo;
    }
}
