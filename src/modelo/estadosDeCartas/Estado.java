package modelo.estadosDeCartas;
import modelo.cartas.Carta;
import modelo.excepciones.VictoriaException;

public interface Estado {
    void darVuelta(Carta carta) throws  VictoriaException;
}
