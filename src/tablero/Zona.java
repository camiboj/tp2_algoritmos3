package tablero;
import cartas.Carta;
import cartas.invocacion.Invocacion;

public interface Zona {
    boolean colocarCarta(Invocacion invocacion);
    void eliminarCarta(Carta carta);
}