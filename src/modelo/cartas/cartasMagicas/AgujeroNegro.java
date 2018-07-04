package modelo.cartas.cartasMagicas;
import modelo.tablero.Tablero;

public class AgujeroNegro extends CartaMagica {
    private Tablero tablero;

    public AgujeroNegro() {
		super("Agujero Negro");
        this.descripcionEfecto = "Destruye todos los monstruos del campo";
	}
    @Override
    public void asignarTablero(Tablero tablero){
            this.tablero=tablero;
    }

    public void activarEfecto() {
        tablero.borrarMonstruos();
    }
}
