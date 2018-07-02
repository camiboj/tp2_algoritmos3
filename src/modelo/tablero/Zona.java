package modelo.tablero;
import modelo.cartas.Carta;
import modelo.cartas.invocacion.Invocacion;
import modelo.excepciones.VictoriaException;

import java.util.List;

public interface Zona {
    boolean colocarCarta(Invocacion invocacion) throws VictoriaException;
    void eliminarCarta(Carta carta);
    List<Casillero> obtenerCasilleros();
}