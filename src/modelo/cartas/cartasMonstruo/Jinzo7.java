package modelo.cartas.cartasMonstruo;

import modelo.efectos.Efecto;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public class Jinzo7 extends CartaMonstruo implements Efecto {
    Jugador jugadorOponente;


    public Jinzo7 (Jugador unJugadorOponente)  {
        super("Jinzo7", 500, 400, 2);
        jugadorOponente = unJugadorOponente;
        this.descripcionEfecto = "Puede atacar directamente los puntos de vida del jugador oponente.";
    }

    @Override
    public void activarEfecto() {
        jugadorOponente.restarPuntos(this.puntosAtaque);
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

    }


}
