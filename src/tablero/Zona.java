package tablero;
import cartas.Carta;
import cartas.invocacion.Invocacion;

import java.util.List;

public interface Zona {
    boolean colocarCarta(Invocacion invocacion);
    void eliminarCarta(Carta carta);
    List<Casillero> obtenerCasilleros();
}