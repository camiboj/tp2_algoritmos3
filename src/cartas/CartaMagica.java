package cartas;
import efectos.Efecto;
import jugador.Jugador;
import tablero.Tablero;

public abstract class CartaMagica extends Carta {


    public CartaMagica(String unNombre) {
        super(unNombre);
    }


    public void activarEfecto(Tablero tablero, Jugador jugadorInvocador) {}
}
