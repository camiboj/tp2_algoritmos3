package jugador;
import cartas.Carta;
import cartas.cartasMonstruo.exodia.CartaMonstruoExodia;

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

    public boolean sonTodasExodia() {
        for (Carta carta: cartas) {
            boolean resultado = carta instanceof CartaMonstruoExodia;
            if (! resultado) { return false; }
        }
        return true;
    }
}
