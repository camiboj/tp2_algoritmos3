package tablero;
import cartas.Carta;
import cartas.CartaMonstruo;

public class CasilleroMonstruo extends Casillero {
    private CartaMonstruo carta;
    private boolean estaVacio;

    public CasilleroMonstruo() { super(); }

    public CartaMonstruo mostrarCarta() {
        return carta;
    }
}
