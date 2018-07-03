package modelo.Fase;

import modelo.excepciones.FinDelJuegoException;
import modelo.excepciones.VictoriaException;

public interface Fase {
    void finFase() throws FinDelJuegoException;
    void ejecutarFase() throws VictoriaException;
}
