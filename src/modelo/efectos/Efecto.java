package modelo.efectos;

import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public interface Efecto {
    void activarEfecto() throws VictoriaException;
    void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero);

}
