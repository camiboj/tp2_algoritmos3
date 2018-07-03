package modelo.Fase;

import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;

public class FaseAtaque implements Fase {
    Jugador jugador;

    public FaseAtaque(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void finFase() {
        //AtaqueDeMonstruos
    }

    @Override
    public void ejecutarFase() throws VictoriaException {

    }
}
