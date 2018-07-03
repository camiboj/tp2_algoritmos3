package modelo.Fase;

import modelo.excepciones.FinDelJuegoException;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;

public class FaseInicial implements Fase {
    Jugador jugador;

    public FaseInicial(Jugador unJugador) {
        jugador = unJugador;
    }

    public void ejecutarFase() throws VictoriaException {
        jugador.agarraCartas(1); //Jugador agarra 1 carta
    }

    @Override
    public void finFase() throws FinDelJuegoException {

    }
}
