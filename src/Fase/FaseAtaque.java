package Fase;

import jugador.Jugador;

public class FaseAtaque implements Fase {
    Jugador jugador;

    public FaseAtaque(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void finFase() {
        //AtaqueDeMonstruos
    }
}
