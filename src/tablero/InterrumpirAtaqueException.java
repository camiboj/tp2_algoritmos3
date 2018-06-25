package tablero;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class InterrumpirAtaqueException extends Exception {
    Carta CartaUsada;
    Jugador jugadorQueLaJugo;
    Jugador jugadorAtacante;
    CartaMonstruo cartaConNuevoAtaque = null;
    List <Carta> cartasDestruidasDelAtacante;


    //esta excepcion es para evitar la resolucion del ataque cuando algo interrumpe la ejecucion de un ataque
    public  InterrumpirAtaqueException(Carta cartaActivada, Jugador jugadorQueLaActivo){
        CartaUsada=cartaActivada;
        jugadorQueLaJugo=jugadorQueLaActivo;
        cartasDestruidasDelAtacante= new ArrayList<Carta>();
    }

    public  InterrumpirAtaqueException(Carta cartaActivada, Jugador jugadorQueLaActivo,CartaMonstruo cartaNuevoAtaque){
        CartaUsada=cartaActivada;
        jugadorQueLaJugo=jugadorQueLaActivo;
        cartaConNuevoAtaque=cartaNuevoAtaque;
        cartasDestruidasDelAtacante= new ArrayList<Carta>();
    }
    public InterrumpirAtaqueException(Jugador jugadorPoseedor, Jugador jugadorEnemigo, List<Carta> cartasDestruidasDelAtacantePorElEfecto) {
        jugadorAtacante=jugadorEnemigo;
        jugadorQueLaJugo=jugadorPoseedor;
        cartasDestruidasDelAtacante=cartasDestruidasDelAtacantePorElEfecto;

    }

    public Carta obtenerCartaUsada() {
        return CartaUsada;
    }

    public Jugador obtenerJugadorQueLaJugo() {
        return jugadorQueLaJugo;
    }
    public Jugador obtenerJugadorAtacante() {
        return jugadorAtacante;
    }
    public List<Carta> obtenercartasDestruidasDelAtacante() {
        return cartasDestruidasDelAtacante;
    }

    public CartaMonstruo obtenerCartaNuevoAtaque() { return cartaConNuevoAtaque;
    }
}
