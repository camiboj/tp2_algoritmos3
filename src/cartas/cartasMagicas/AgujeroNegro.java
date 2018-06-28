package cartas.cartasMagicas;
import jugador.Jugador;
import tablero.Tablero;

public class AgujeroNegro extends CartaMagica {
    private Tablero tablero;

    public AgujeroNegro(Tablero unTablero) {
		super("Agujero Negro");
		tablero = unTablero;
	}


    public void activarEfecto() {
        tablero.borrarMonstruos();
    }
}
