package efectos;

import excepciones.VictoriaException;
import jugador.Jugador;
import tablero.Tablero;

public interface Efecto {
    void activarEfecto() throws VictoriaException;
    void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero);

}
