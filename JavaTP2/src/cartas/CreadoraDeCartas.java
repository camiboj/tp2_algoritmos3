package cartas;
import efectos.AgujeroNegro;

public class CreadoraDeCartas {
	public static final Carta crearCarta(String nombre) {
		switch (nombre) {
		case "Agujero Negro":
			return new AgujeroNegro();
		default:
			break;
		}
		return null;
	}
}
