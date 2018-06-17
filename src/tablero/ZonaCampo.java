package tablero;
import cartas.Carta;

public class ZonaCampo implements Zona {
    private Casillero casillero; //Momentaneo: entiendo que hay una carta en el tablero
    private boolean estaCompleto;

    public ZonaCampo() {
        casillero = new Casillero();
    }

    public boolean colocarCarta(Carta carta) {
        return true;
    }
}


