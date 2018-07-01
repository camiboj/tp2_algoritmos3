package estadosDeCartas;
import cartas.Carta;
import excepciones.VictoriaException;

public interface Estado {
    void darVuelta(Carta carta) throws  VictoriaException;
}
