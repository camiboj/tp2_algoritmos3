package modelo.cartas.cartasMagicas;
import modelo.tablero.Tablero;

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
