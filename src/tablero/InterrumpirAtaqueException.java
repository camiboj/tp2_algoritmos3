package tablero;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;

public class InterrumpirAtaqueException extends Exception {
    Carta CartaUsada;
    Jugador jugadorQueLaJugo;
    CartaMonstruo cartaConNuevoAtaque = null;
    //esta excepcion es para evitar la resolucion del ataque cuando algo interrumpe la ejecucion de un ataque
    public  InterrumpirAtaqueException(Carta cartaActivada, Jugador jugadorQueLaActivo){
        CartaUsada=cartaActivada;
        jugadorQueLaJugo=jugadorQueLaActivo;
    }

    public  InterrumpirAtaqueException(Carta cartaActivada, Jugador jugadorQueLaActivo,CartaMonstruo cartaNuevoAtaque){
        CartaUsada=cartaActivada;
        jugadorQueLaJugo=jugadorQueLaActivo;
        cartaConNuevoAtaque=cartaNuevoAtaque;
    }
    public InterrumpirAtaqueException() {
    }

    public Carta obtenerCartaUsada() {
        return CartaUsada;
    }

    public Jugador obtenerJugadorQueLaJugo() {
        return jugadorQueLaJugo;
    }

    public CartaMonstruo obtenerCartaNuevoAtaque() { return cartaConNuevoAtaque;
    }
}
