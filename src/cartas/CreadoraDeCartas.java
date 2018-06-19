package cartas;

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
				return new AgujeroNegro();
			case "Alcanzador de Garra":
				return new AlcanzadorDeGarra();

		default:
			break;
		}
		return null;
	}
}