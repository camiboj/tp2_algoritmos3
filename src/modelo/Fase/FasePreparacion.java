package modelo.Fase;

import modelo.jugador.Jugador;

public class FasePreparacion implements Fase {
    Jugador jugador;

    public FasePreparacion(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void finFase() {
    //Puede colocar cartasTrampa y de magia pero 1 monstruo. Como hacer esto? modelo.Fase conoce a Tablero?
    }
}
