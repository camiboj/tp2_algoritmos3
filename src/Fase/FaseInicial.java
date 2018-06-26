package Fase;

import jugador.Jugador;

public class FaseInicial implements Fase {
    Jugador jugador;

    public FaseInicial(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void ejecutarFase() {
        jugador.agarraCartas(1); //Jugador agarra 1 carta
    }
}
