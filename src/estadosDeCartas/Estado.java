package estadosDeCartas;
import cartas.Carta;
import tablero.InterrumpirAtaqueException;

public interface Estado {
    void darVuelta(Carta carta) throws InterrumpirAtaqueException;
}
