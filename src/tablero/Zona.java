package tablero;
import cartas.Carta;

public interface Zona {
    boolean colocarCarta(Carta carta);
    void eliminar(Carta carta);
}