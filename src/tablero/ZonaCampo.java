package tablero;
import cartas.Carta;

public class ZonaCampo implements Zona {
    private Casillero casillero; //Momentaneo: entiendo que hay una carta en el tablero

    public ZonaCampo() {
        casillero = new Casillero();
    }

    public boolean colocarCarta(Carta carta) {
        //Devuelve true si pudo colocarla y false si la zona estaba completa
        if (casillero.estaVacio()) {
            casillero.colocarCarta(carta);
            return true;
        }
        return false;
    }
}


