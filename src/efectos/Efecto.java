package efectos;

import cartas.Carta;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;
import tablero.LadoDelCampo;

public interface Efecto {
    void activarEfecto();
    void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, LadoDelCampo ladoEnemigo) throws InterrumpirAtaqueException;

}
