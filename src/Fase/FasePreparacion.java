package Fase;

import jugador.Jugador;

public class FasePreparacion implements Fase {
    Jugador jugador;

    public FasePreparacion(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void ejecutarFase() {
    //Puede colocar cartasTrampa y de magia pero 1 monstruo. Como hacer esto? Fase conoce a Tablero?
    }
}
