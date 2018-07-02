package modelo.Fase;

import modelo.excepciones.FinDelJuegoException;

public interface Fase {
    void finFase() throws FinDelJuegoException;
}
