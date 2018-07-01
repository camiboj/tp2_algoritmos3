package jugador;

import Fase.Fase;
import Fase.FaseInicial;
import Fase.FaseAtaque;
import Fase.FaseTrampa;
import Fase.FaseMagia;
import Fase.FasePreparacion;
import excepciones.FinDelJuegoException;

import java.util.ArrayList;
import java.util.List;

public class Turno {
    List<Fase> fases;
    Jugador jugador;

    public Turno(Jugador unJugador) {

        jugador = unJugador;
        fases = new ArrayList();
        fases.add(new FaseInicial(unJugador));
        fases.add(new FasePreparacion(unJugador));
        FaseTrampa faseTrampa = new FaseTrampa(unJugador);
        fases.add(new FaseAtaque(unJugador));
        fases.add(new FaseMagia(unJugador));
    }

    public void cambiarDeFase() throws FinDelJuegoException {
        /*    for(Fase fase : fases) {
            fase.finFase();
        }
        */
    }
}