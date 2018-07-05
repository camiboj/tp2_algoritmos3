package modelo.tablero;
import modelo.cartas.*;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import modelo.cartas.invocacion.Invocacion;
import modelo.cartas.invocacion.InvocacionCartaMonstruo;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.excepciones.ZonaTrampaMagicaLlenaException;
import modelo.jugador.Jugador;
import modelo.jugador.Mazo;

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

		miMazo = new Mazo("mazoJugador1",miJugador, jugadorContrario, zonaMonstruoContraria, miZonaMonstruo, tablero);
		miJugador.guardarMazo(miMazo);
	}
	public Cementerio mostrarCementerio() {
		return miCementerio;
	}

	public int colocarZonaTrampaMagica(InvocacionDefault unaInvocacion) throws ZonaTrampaMagicaLlenaException {
		return miZonaDeTrampasYMagia.colocarCarta(unaInvocacion);
	}

	public int colocarZonaMonstruo(Carta carta) throws ZonaMonstruoLlenaException, InvocacionExcepcion {
		return miZonaMonstruo.colocarCarta(carta);
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

	public boolean colocarZonaCampo(InvocacionDefault unaInvocacion)  {
		return miZonaCampo.colocarCarta(unaInvocacion);
	}

	public void eliminarMonstruoDebil() {
		modelo.cartas.cartasMonstruo.CartaMonstruo cartaDebil = miZonaMonstruo.obtenerMonstruoDebil();
		eliminarDeZonaMonstruo(cartaDebil);
		colocarCementerio(cartaDebil);
	}

	public boolean zonaTrampaMagicaEstaVacia() {
		return miZonaDeTrampasYMagia.estaVacia();
	}

	public void activarTrampa(Carta trampa, modelo.cartas.cartasMonstruo.CartaMonstruo cartaAtacante, Jugador jugadorAtacante, modelo.cartas.cartasMonstruo.CartaMonstruo cartaDefensora,
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

	public List <modelo.cartas.cartasMonstruo.CartaMonstruo> obtenerMonstruos() {
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


	public ZonaCampo mostrarZonaCampo() {
		return miZonaCampo;
	}

    public boolean cartaEnZonaMonstruo(CartaMonstruo carta) {
		return miZonaMonstruo.existe(carta);
    }
}