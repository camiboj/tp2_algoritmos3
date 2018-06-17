package efectos;
import cartas.Carta;
import cartas.HuevoMonstruoso;
import tablero.Cementerio;

public class AgujeroNegro extends Carta{
    public AgujeroNegro() {
		super("Agujero Negro");
		// TODO Auto-generated constructor stub
	}

	public Cementerio getUbicacion() {
        return new Cementerio();
    }

    public void atacar(HuevoMonstruoso huevoMonstruoso) {
    }
}
