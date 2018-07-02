package modelo.cartas;

import modelo.cartas.cartasCampo.Wasteland;
import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.cartasMagicas.OllaDeLaCodicia;
import modelo.cartas.cartasMonstruo.cartasBasicas.*;
import modelo.cartas.cartasMonstruo.exodia.*;
import modelo.cartas.cartasTrampa.CilindroMagico;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

public class CreadoraDeCartas {
	public static final Carta crearCarta(String nombre, Jugador jugador, Jugador jugadorContrario,
										 ZonaMonstruo zonaMonstruoAtacante, ZonaMonstruo zonaMonstruoPropia, Tablero tablero) {
		switch (nombre) {
			case "Huevo Monstruoso":
				return new HuevoMonstruoso();
			case "AlasDeLaLlamaPerversa":
				return new AlasDeLaLlamaPerversa();
			case "Cilindro Magico":
				return new CilindroMagico();
			case "Agujero Negro":
				return new AgujeroNegro(tablero);
			case "Alcanzador de Garra":
				return new AlcanzadorDeGarra();
			case "Araña Lanzadora":
				return new ArañaLanzadora();
			case "Bestia De Talwar":
				return new BestiaDeTalwar();
			case "Aitsu":
				return new Aitsu();
			case "Wasteland":
				return new Wasteland(zonaMonstruoAtacante, zonaMonstruoPropia);
			case "Olla De La Codicia":
				return new OllaDeLaCodicia(jugador);
			case "Brazo Derecho Del Prohibido":
				return new BrazoDerechoDelProhibido();
			case "Brazo Izquierdo Del Prohibido":
				return new BrazoIzquierdoDelProhibido();
			case "Pierna Derecha Del Prohibido":
				return new PiernaDerechaDelProhibido();
			case "Pierna Izquierda Del Prohibido":
				return new PiernaIzquierdaDelProhibido();
			case "Exodia El Prohibido":
				return  new ExodiaElProhibido();

		default:
			break;
		}
		return null;
	}
}