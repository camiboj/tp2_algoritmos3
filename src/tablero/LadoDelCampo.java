package tablero;
import cartas.*;
import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasTrampa.CartaTrampa;
import cartas.invocacion.Invocacion;
import cartas.invocacion.InvocacionCartaMonstruo;
import excepciones.VictoriaException;
import jugador.Jugador;
import jugador.Mazo;

import java.util.List;

public class LadoDelCampo {
	private Cementerio miCementerio;
	private Mazo miMazo;
	private ZonaCampo miZonaCampo;
	private ZonaTrampaMagica miZonaDeTrampasYMagia;
	private ZonaMonstruo miZonaMonstruo;

	@Override
	public boolean equals(Object object) {
		return this.getClass().equals(object.getClass());
	}

	public LadoDelCampo() {
		miCementerio = new Cementerio();
		miZonaCampo = new ZonaCampo();
		miZonaDeTrampasYMagia = new ZonaTrampaMagica();
		miZonaMonstruo = new ZonaMonstruo() {
		};
	}

	public void guardarMazo(Jugador miJugador, Jugador jugadorContrario,
							ZonaMonstruo zonaMonstruoContraria, Tablero tablero) throws VictoriaException {
		miMazo = new Mazo("",miJugador, jugadorContrario, zonaMonstruoContraria, miZonaMonstruo, tablero);
		miJugador.guardarMazo(miMazo);
	}
	public Cementerio mostrarCementerio() {
		return miCementerio;
	}

	public boolean colocarZonaTrampaMagica(Invocacion unaInvocacion) {
		return miZonaDeTrampasYMagia.colocarCarta(unaInvocacion);
	}

	public boolean colocarZonaMonstruo(InvocacionCartaMonstruo unaInvocacion) {
		return miZonaMonstruo.colocarCarta(unaInvocacion);
	}

	public void colocarCementerio(Carta unaCarta) {
		miCementerio.colocarCarta(unaCarta);

	}

	public void eliminarDeZonaMonstruo(CartaMonstruo unaCarta) {
		miZonaMonstruo.eliminarCarta(unaCarta);
	}

	public ZonaMonstruo mostrarZonaMonstruo() {
		return miZonaMonstruo;
	}

	public void borrarMonstruos() {
		miZonaMonstruo.borrarMonstruos(miCementerio);
	}

	public boolean zonaMonstruoEstaVacia() {
		return miZonaMonstruo.estaVacia();
	}

	public boolean colocarZonaCampo(Invocacion unaInvocacion) throws VictoriaException {
		return miZonaCampo.colocarCarta(unaInvocacion);
	}

	public void eliminarMonstruoDebil() {
		CartaMonstruo cartaDebil = miZonaMonstruo.obtenerMonstruoDebil();
		eliminarDeZonaMonstruo(cartaDebil);
		colocarCementerio(cartaDebil);
	}

	public boolean zonaTrampaMagicaEstaVacia() {
		return miZonaDeTrampasYMagia.estaVacia();
	}

	public void activarTrampa(Carta trampa, CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo cartaDefensora,
							  Jugador jugadorDefensor, Tablero tablero) {
		miZonaDeTrampasYMagia.activar(trampa, cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor, tablero);
	}

	public List <CartaTrampa> obtenerTrampas() {
		return miZonaDeTrampasYMagia.obtenerCartasTrampas();
	}

	public void eliminarDeZonaTrampaMagica(Carta carta) {
		miZonaDeTrampasYMagia.eliminarCarta(carta);

	}

	public ZonaTrampaMagica mostrarZonaTrampaMagica() {
		return miZonaDeTrampasYMagia;
	}

	public List <CartaMonstruo> obtenerMonstruos() {
		return miZonaMonstruo.obtenerMonstruos();
	}

    public List<Casillero> mostrarCasillerosZonaMonstruo() {
		return miZonaMonstruo.obtenerCasilleros();
    }

	public List<Casillero> mostrarCasillerosZonaCampo() {
		return miZonaCampo.obtenerCasilleros();
	}

	public List<Casillero> mostrarCasillerosZonaTrampaMagica() {
		return miZonaDeTrampasYMagia.obtenerCasilleros();
	}

	public ZonaMonstruo obtenerZonaMonstruos() {
		return miZonaMonstruo;
	}


}