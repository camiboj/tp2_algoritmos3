package cartas.cartasMonstruo;

import jugador.Jugador;

public class Jinzo7 extends CartaMonstruo implements CartaMonstruoConEfecto {
    Jugador jugadorOponente;

    public Jinzo7 (Jugador unJugadorOponente)  {
        super("Jinzo7", 500, 400, 2);
        jugadorOponente = unJugadorOponente;
    }

    public void activarEfecto() {
        jugadorOponente.restarPuntos(this.puntosAtaque);
    }

}
