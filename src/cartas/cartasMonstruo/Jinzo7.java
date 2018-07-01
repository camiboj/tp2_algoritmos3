package cartas.cartasMonstruo;

import efectos.Efecto;
import jugador.Jugador;
import tablero.Tablero;

public class Jinzo7 extends CartaMonstruo implements Efecto {
    Jugador jugadorOponente;


    public Jinzo7 (Jugador unJugadorOponente)  {
        super("Jinzo7", 500, 400, 2);
        jugadorOponente = unJugadorOponente;
    }

    @Override
    public void activarEfecto() {
        jugadorOponente.restarPuntos(this.puntosAtaque);
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

    }


}
