package modelo.cartas.invocacion;

import modelo.cartas.Carta;
import modelo.excepciones.InvocacionExcepcion;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public abstract class Invocacion {
    protected Carta carta;

    public Invocacion(Carta unaCarta) {
        carta = unaCarta;
    }

    public void asignarJugadorACarta(Jugador jugador) {
        if (carta !=null){
            carta.asignarJugador(jugador);
        }
    }

    public void asignarTablero(Tablero tablero) {
        if (carta !=null){
            carta.asignarTablero(tablero);
        }
    }
}
