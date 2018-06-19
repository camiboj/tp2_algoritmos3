package tablero;
import cartas.Carta;
import cartas.Invocacion;

public class ZonaCampo implements Zona {
    private Casillero casillero; //Momentaneo: entiendo que hay una carta en el tablero

    public ZonaCampo() {
        casillero = new Casillero();
    }

    public boolean colocarCarta(Invocacion invocacion) {
        //Devuelve true si pudo colocarla y false si la zona estaba completa
        if (casillero.estaVacio()) {
            Carta carta = invocacion.invocar();
            casillero.colocarCarta(carta);
            return true;
        }
        return false;
    }

    public void eliminarCarta(Carta carta) {
        return;
    }
}


