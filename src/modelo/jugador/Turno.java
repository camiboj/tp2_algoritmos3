package modelo.jugador;

import modelo.Fase.Fase;
import modelo.Fase.FaseInicial;
import modelo.Fase.FaseAtaque;
import modelo.Fase.FaseTrampa;
import modelo.Fase.FaseMagia;
import modelo.Fase.FasePreparacion;
import modelo.excepciones.FinDelJuegoException;

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
        /*    for(modelo.Fase fase : fases) {
            fase.finFase();
        }
        */
    }
}