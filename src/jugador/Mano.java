package jugador;
import cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public int obtenerCantidad() {
        return cartas.size();
    }

    public void sacar(Carta carta) {
        cartas.remove(carta);
    }
}
