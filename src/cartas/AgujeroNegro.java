package cartas;
import cartas.Carta;
import cartas.HuevoMonstruoso;
import jugador.Jugador;
import tablero.Cementerio;
import tablero.Tablero;

public class AgujeroNegro extends CartaMagica{
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
