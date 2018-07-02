package modelo.Fase;

import modelo.jugador.Jugador;

public class FaseMagia implements Fase {
    Jugador jugador;

    public FaseMagia(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void finFase() {
        //Se pueden activar cartasdeMagia
    }
}
