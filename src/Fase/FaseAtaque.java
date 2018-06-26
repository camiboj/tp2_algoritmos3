package Fase;

import jugador.Jugador;

public class FaseAtaque implements Fase {
    Jugador jugador;
    FaseTrampa faseTrampa;

    public FaseAtaque(Jugador unJugador, FaseTrampa unaFaseTrampa) {
        jugador = unJugador;
        faseTrampa = unaFaseTrampa;
    }

    @Override
    public void ejecutarFase() {
        //AtaqueDeMonstruos
        faseTrampa.ejecutarFase();
    }
}
