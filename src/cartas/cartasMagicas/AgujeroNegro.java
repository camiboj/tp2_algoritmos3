package cartas.cartasMagicas;
import jugador.Jugador;
import tablero.Tablero;

public class AgujeroNegro extends CartaMagica {
    private Tablero tablero;
    private Jugador jugador;

    public AgujeroNegro(Tablero unTablero, Jugador unJugador) {
		super("Agujero Negro");
		tablero = unTablero;
		jugador = unJugador;
	}


    public void activarEfecto() {
        tablero.borrarMonstruos();
    }
}
