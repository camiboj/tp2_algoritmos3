package Fase;

import excepciones.FinDelJuegoException;
import excepciones.VictoriaException;
import jugador.Jugador;

public class FaseInicial implements Fase {
    Jugador jugador;

    public FaseInicial(Jugador unJugador) {
        jugador = unJugador;
    }

    @Override
    public void ejecutarFase() throws FinDelJuegoException {
        try {
            jugador.agarraCartas(1); //Jugador agarra 1 carta
        } catch (VictoriaException datos) {
            throw new FinDelJuegoException(datos.obtenerMotivo(),jugador);
        }
    }
}
