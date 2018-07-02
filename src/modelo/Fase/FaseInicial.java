package modelo.Fase;

import modelo.excepciones.FinDelJuegoException;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;

public class FaseInicial implements Fase {
    Jugador jugador;

    public FaseInicial(Jugador unJugador) {
        jugador = unJugador;
    }

    public void ejecutarFase() throws FinDelJuegoException {
        try {
            jugador.agarraCartas(1); //Jugador agarra 1 carta
        } catch (VictoriaException datos) {
            throw new FinDelJuegoException(datos.obtenerMotivo(),jugador);
        }
    }

    @Override
    public void finFase() throws FinDelJuegoException {

    }
}
