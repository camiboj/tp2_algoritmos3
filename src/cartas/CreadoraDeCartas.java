package cartas;

import cartas.cartasCampo.Wasteland;
import cartas.cartasMonstruo.cartasBasicas.*;
import cartas.cartasMonstruo.exodia.*;
import cartas.cartasTrampa.CilindroMagico;

public class CreadoraDeCartas {
	public static final Carta crearCarta(String nombre) {
		switch (nombre) {
			case "Huevo Monstruoso":
				return new HuevoMonstruoso();
			case "AlasDeLaLlamaPerversa":
				return new AlasDeLaLlamaPerversa();
			case "Cilindro Magico":
				return new CilindroMagico();
			case "Agujero Negro":
				//return new AgujeroNegro();
			case "Alcanzador de Garra":
				return new AlcanzadorDeGarra();
			/*case "Araña Lanzadora":
				return new ArañaLanzadora();
			case "Bestia De Talwar":
				return new BestiaDeTalwar();*/
			/*case "Aitsu":
				return new Aitsu();
			case "Wasteland":
				return new Wasteland();
			*/
			//case "Olla De La Codicia":
				//return new OllaDeLaCodicia();
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