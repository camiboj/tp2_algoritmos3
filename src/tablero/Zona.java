package tablero;
import cartas.Carta;
import cartas.invocacion.Invocacion;
import excepciones.VictoriaException;

import java.util.List;

public interface Zona {
    boolean colocarCarta(Invocacion invocacion) throws VictoriaException;
    void eliminarCarta(Carta carta);
    List<Casillero> obtenerCasilleros();
}