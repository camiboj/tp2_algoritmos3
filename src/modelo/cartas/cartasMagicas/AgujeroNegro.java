package modelo.cartas.cartasMagicas;
import modelo.tablero.Tablero;

public class AgujeroNegro extends CartaMagica {
    private Tablero tablero;

    public AgujeroNegro(Tablero unTablero) {
		super("Agujero Negro");
		tablero = unTablero;
        this.descripcionEfecto = "Destruye todos los monstruos del campo";
	}


    public void activarEfecto() {
        tablero.borrarMonstruos();
    }
}
