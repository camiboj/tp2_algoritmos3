package tablero;
import java.util.HashMap;
import java.util.List;

import cartas.*;
import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasTrampa.CartaTrampa;
import cartas.invocacion.Invocacion;
import cartas.invocacion.InvocacionCartaCampo;
import cartas.invocacion.InvocacionCartaMonstruo;
import jugador.Jugador;
import jugador.Punto;


public class Tablero {
	private HashMap<Jugador, LadoDelCampo> divisiones;

	public Tablero(Jugador jugador1, Jugador jugador2) {

		divisiones = new HashMap<Jugador, LadoDelCampo>();
		divisiones.put(jugador1, new LadoDelCampo());
		divisiones.put(jugador2, new LadoDelCampo());
	}

	public LadoDelCampo get(Jugador jugador1) {
		return divisiones.get(jugador1);
	}

	public boolean colocarZonaCampo(Invocacion unaInvocacion, Jugador jugador) {
		//Si es Wasteland: primero pasar Jugador y después JugadorOponente
		//Si es Sogen: primero pasar JugadorOponente y después Jugador

		LadoDelCampo ladoDelCampo = divisiones.get(jugador);

		return ladoDelCampo.colocarZonaCampo(unaInvocacion);
	}

	public Cementerio mostrarCementerio(Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		return ladoDelCampo.mostrarCementerio();
	}

	public boolean colocarZonaTrampaMagica(Invocacion unaInvocacion, Jugador jugador) {
		Carta carta = unaInvocacion.invocar();
		jugador.sacarDeMano(carta);
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		this.colocarCementerio(carta, jugador);
		return ladoDelCampo.colocarZonaTrampaMagica(unaInvocacion);
	}
	//colocar sin sacrificio y sin sacrificios
	//llamar a la invocacion para que lo haga y le paso zona monstruo y cementerio
	public boolean colocarZonaMonstruo(InvocacionCartaMonstruo unaInvocacion, Jugador jugador) {
		if (unaInvocacion.debeSacrificar()) {
			List<CartaMonstruo> sacrificios = unaInvocacion.mostrarCartasASacrificar();
			for (CartaMonstruo carta : sacrificios) {
				colocarCementerio(carta, jugador);
				eliminarDeZonaMonstruo(carta, jugador);
			}
		}
		Carta carta = unaInvocacion.invocar();
		jugador.sacarDeMano(carta);
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaMonstruo(unaInvocacion);
	}

	public void colocarCementerio(Carta unaCarta, Jugador jugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		ladoDelCampo.colocarCementerio(unaCarta);
	}

	public void atacarDosMonstruos(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo cartaDefensora,
								   Jugador jugadorDefensor) {

		//Activacion de la carta trampa
		if (!divisiones.get(jugadorDefensor).zonaTrampaMagicaEstaVacia()){
			try {
				List<CartaTrampa> cartasTrampa = divisiones.get(jugadorDefensor).obtenerTrampas();
				for (CartaTrampa trampa:
					 cartasTrampa) {
					divisiones.get(jugadorDefensor).activarTrampa(trampa, cartaAtacante, jugadorAtacante, cartaDefensora,jugadorDefensor);
				    eliminarDeZonaTrampaMagica(trampa, jugadorDefensor);
				}
			}
			catch (InterrumpirAtaqueException datos){
				colocarCartaEnCementerio(datos.obtenerCartaUsada(), datos.obtenerJugadorQueLaJugo());
				return;
			}
		}

		//Ejecucion del ataque de dos monstruos
		CartaMonstruo cartaGanadora = cartaAtacante.obtenerGanadoraContra(cartaDefensora);
		Jugador jugadorPerdedor;
		Jugador jugadorGanador;
		CartaMonstruo cartaPerdedora;
		if (cartaDefensora == cartaGanadora && cartaDefensora.enModoDefensa()) {
			return;
		}
		if (cartaGanadora == cartaDefensora) {
			jugadorPerdedor = jugadorAtacante;
			cartaPerdedora = cartaAtacante;
			jugadorGanador = jugadorDefensor;
		} else {
			jugadorPerdedor = jugadorDefensor;
			cartaPerdedora = cartaDefensora;
			jugadorGanador = jugadorAtacante;
		}

		colocarCementerio(cartaPerdedora, jugadorPerdedor);
		eliminarDeZonaMonstruo(cartaPerdedora, jugadorPerdedor);
		if (cartaDefensora.enModoDefensa()) {
			return;
		}
		Punto puntosGanadores = cartaGanadora.obtenerPuntos();
		Punto puntosPerdedores = cartaPerdedora.obtenerPuntos();
		Punto diferenciaPuntos = puntosGanadores.restar(puntosPerdedores);
		jugadorPerdedor.restarPuntos(diferenciaPuntos);

		//Caso especial de que ambas cartas tengan la misma cantidad de puntos de ataque
		if (cartaGanadora.igualPuntos(cartaDefensora)) {
			colocarCementerio(cartaGanadora, jugadorGanador);
			eliminarDeZonaMonstruo(cartaGanadora, jugadorGanador);
		}
	}

    private void eliminarDeZonaTrampaMagica(CartaTrampa unaCarta, Jugador unJugador) {
        LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
        ladoDelCampo.eliminarDeZonaTrampaMagica(unaCarta);
    }

    private void colocarCartaEnCementerio(Carta carta, Jugador jugador) {
		divisiones.get(jugador).eliminarDeZonaTrampaMagica(carta);
		divisiones.get(jugador).colocarCementerio(carta);
	}

	private void eliminarDeZonaMonstruo(CartaMonstruo unaCarta, Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		ladoDelCampo.eliminarDeZonaMonstruo(unaCarta);
	}

	public ZonaMonstruo mostrarZonaMonstruo(Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		return ladoDelCampo.mostrarZonaMonstruo();
	}

	public void borrarMonstruos() {
		for (LadoDelCampo unLadoDelCampo : divisiones.values()) {
			unLadoDelCampo.borrarMonstruos();
		}
	}

	public boolean noTieneCartasMonstruo() {
		for (LadoDelCampo l : divisiones.values()) {
			if (!l.zonaMonstruoEstaVacia()) return false;
		}
		return true;
	}


	public void eliminarMonstruoDebil(Jugador jugadorAtacante) {
		Jugador jugador = this.buscarOponente(jugadorAtacante);
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		ladoDelCampo.eliminarMonstruoDebil();
	}

	private Jugador buscarOponente(Jugador jugadorAtacante) {
		Jugador jugadorADevolver = null;
		for (Jugador jugador : divisiones.keySet()) {
			if (jugador != jugadorAtacante) {
				jugadorADevolver = jugador;
			}
		}
		return jugadorADevolver;
	}


    public ZonaTrampaMagica mostrarZonaTrampaMagica(Jugador unJugador) {
        LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
        return ladoDelCampo.mostrarZonaTrampaMagica();
	}

	public LadoDelCampo mostrarLadoDelCampo(Jugador jugadorOponente) {
		return divisiones.get(jugadorOponente);
	}
}