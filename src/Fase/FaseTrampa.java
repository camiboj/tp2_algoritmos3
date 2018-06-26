package Fase;

import jugador.Jugador;

public class FaseTrampa implements Fase {
    Jugador jugador;

    public FaseTrampa(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void ejecutarFase() {
        //Se ejecutan las trampas
    }
}
