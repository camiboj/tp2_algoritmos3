package modelo.cartas.cartasMonstruo;

import com.intellij.vcs.log.Hash;
import modelo.efectos.Efecto;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

import java.util.HashMap;

public class Jinzo7 extends CartaMonstruo implements Efecto {
    Jugador jugadorOponente;
    Jugador jugadorPropio;
    Tablero tablero;

    public Jinzo7 ()  {
        super("Jinzo7", 500, 400, 2);
        this.descripcionEfecto = "Puede atacar directamente los puntos de vida del jugador oponente.";
    }

    @Override
    public void asignarJugador(Jugador jugador){
        jugadorPropio=jugador;
        if (tablero!=null){
            jugadorOponente=tablero.obtenerJugadorOponente(jugadorPropio);
        }
    }
    @Override
    public void asignarTablero(Tablero tablero){
        this.tablero=tablero;
        if (jugadorPropio!=null){
            jugadorOponente=tablero.obtenerJugadorOponente(jugadorPropio);
        }
    }
    @Override
    public void activarEfecto() {
        if (jugadorOponente!=null)
        jugadorOponente.restarPuntos(this.puntosAtaque);
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

    }


}
