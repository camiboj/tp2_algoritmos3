package Fase;

import jugador.Jugador;

public class FaseMagia implements Fase {
    Jugador jugador;

    public FaseMagia(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void ejecutarFase() {
        //Se pueden activar cartasdeMagia
    }
}
