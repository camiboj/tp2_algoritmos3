package modelo.Fase;

import modelo.excepciones.FinDelJuegoException;
import modelo.jugador.Jugador;

public class FaseTrampa implements Fase {
    Jugador jugador;

    public FaseTrampa(Jugador unJugador) {
        jugador = unJugador;
    }

    public void ejecutarFase() {
        //Se ejecutan las trampas
    }

    @Override
    public void finFase() throws FinDelJuegoException {

    }
}
