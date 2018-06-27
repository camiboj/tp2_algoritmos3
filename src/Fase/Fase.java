package Fase;

import excepciones.FinDelJuegoException;

public interface Fase {
    void ejecutarFase() throws FinDelJuegoException;
}
