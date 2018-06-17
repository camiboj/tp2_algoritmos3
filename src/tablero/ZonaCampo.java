package tablero;
import cartas.Carta;

public class ZonaCampo extends Zona {
    private Casillero casillero; //Momentaneo: entiendo que hay una carta en el tablero

    public ZonaCampo() {
        casillero = new Casillero();
    }
}


