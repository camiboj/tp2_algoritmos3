package modelo.cartas;

import modelo.cartas.cartasCampo.Wasteland;
import modelo.cartas.cartasMagicas.AgujeroNegro;
import modelo.cartas.cartasMagicas.Fisura;
import modelo.cartas.cartasMagicas.OllaDeLaCodicia;
import modelo.cartas.cartasMonstruo.DragonDefinitivoDeOjosAzules;
import modelo.cartas.cartasMonstruo.Jinzo7;
import modelo.cartas.cartasMonstruo.cartasBasicas.*;
import modelo.cartas.cartasMonstruo.exodia.*;
import modelo.cartas.cartasTrampa.CilindroMagico;
import modelo.cartas.cartasTrampa.Reinforcements;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

public class CreadoraDeCartas {
	public static final Carta crearCarta(String nombre, Jugador jugador, Jugador jugadorContrario,
										 ZonaMonstruo zonaMonstruoAtacante, ZonaMonstruo zonaMonstruoPropia, Tablero tablero) {
		switch (nombre) {
			case "Huevo Monstruoso":
				return new HuevoMonstruoso();
			case "Alas De La Llama Perversa":
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
			case "Bebe Dragon":
				return  new BebeDragon();
			case "El Furioso Rey De Los Mares":
				return  new ElFuriosoReyDeLosMares();
			case "Bitron":
				return  new Bitron();
			case "Cementerio De Mamuts":
				return  new CementerioDeMamuts();
			case "Cerebrus De Llamas":
				return  new CerebrusDeLlamas();
			case "Dama Arpia":
				return  new DamaArpia();
			case "Dragon Blanco De Ojos Azules":
				return  new DragonBlancoDeOjosAzules();
			case "Dragon Negro De Ojos Rojos":
				return  new DragonNegroDeOjosRojos();
			case "Escarabajo Hercules":
				return  new EscarabajoHercules();
			case "Escorpion Demonio":
				return  new EscorpionDemonio();
			case "Frostosaurus":
				return  new Frostosaurus();
			case "Gaia El Caballero Feroz":
				return  new GaiaElCaballeroFeroz();
			case "Gente Oprimida":
				return  new GenteOprimida();
			case "Gran Koala":
				return  new GranKoala();
			case "Heroe Del Este":
				return  new HeroeDelEste();
			case "Hierba De Fuego":
				return  new HierbaDeFuego();
			case "Idolo De Los Mil Ojos":
				return  new IdoloDeLosMilOjos();
			case "Incursor Del Hacha":
				return  new IncursorDelHacha();
			case "Juez":
				return  new Juez();
			case "Jugador De Batalla":
				return  new JugadorDeBatalla();
			case "Kanan La Seniora De Las Espadas":
				return  new KananLaSenioraDeLasEspadas();
			case "Kurama":
				return  new Kurama();
			case "Leogun":
				return  new Leogun();
			case "Lobo":
				return  new Lobo();
			case "Mago Oscuro":
				return  new MagoOscuro();
			case "Maldicion De Dragon":
				return  new MaldicionDeDragon();
			case "Murcielago De Meda":
				return  new MurcielagoDeMeda();
			case "Neo Madoor De Agua":
				return  new NeoMadoorDeAgua();
			case "Ogro De Acero":
				return  new OgroDeAcero();
			case "Ojama Amarillo":
				return  new OjamaAmarillo();
			case "Oso Panda Frenetico":
				return  new OsoPandaFrenetico();
			case "Pato Sonico":
				return  new PatoSonico();
			case "Pico Excavador":
				return  new PicoExcavador();
			case "Protron":
				return  new Protron();
			case "Rata De La Prevencion":
				return  new RataDeLaPrevencion();
			case "Renge Custodio Del Mundo Oscuro":
				return  new RengeCustodioDelMundoOscuro();
			case "Seiyaryu":
				return  new Seiyaryu();
			case "Sirviente De La Calavera":
				return  new SirvienteDeLaCalavera();
			case "Soldado Gigante De Piedra":
				return  new SoldadoGiganteDePiedra();
			case "Takuhee":
				return  new Takuhee();
			case "Trent":
				return  new Trent();
			case "Uraby":
				return  new Uraby();
			case "Watt Cola Dragon":
				return  new Wattcoladragon();
			case "Yamadron":
				return  new Yamadron();
			case "Zombi De Dragon":
				return  new ZombiDeDragon();
			case "Jinzo 7":
				return  new Bitron();
			case "Insecto Come Hombres":
				return  new Bitron();
			case "Dragon Definitivo De Ojos Azules":
				return  new DragonDefinitivoDeOjosAzules();
			case "Reinforcements":
				return  new Reinforcements();
			case "Fisura":
				return  new Protron();
			case "Sogen":
				return  new Bitron();



		default:
			break;
		}
		return null;
	}
}