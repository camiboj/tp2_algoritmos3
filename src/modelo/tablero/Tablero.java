package modelo.tablero;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.cartas.*;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import modelo.cartas.invocacion.Invocacion;
import modelo.cartas.invocacion.InvocacionCartaMonstruo;
import modelo.cartas.invocacion.InvocacionDefault;
import modelo.efectos.Efecto;
import modelo.estadosDeCartas.BocaAbajo;
import modelo.excepciones.InvocacionExcepcion;
import modelo.excepciones.VictoriaException;
import modelo.excepciones.ZonaMonstruoLlenaException;
import modelo.jugador.Jugador;
import modelo.jugador.Punto;


public class Tablero {
	private HashMap<Jugador, LadoDelCampo> divisiones;
	private Jugador jugador1;
	private Jugador jugador2;

	public Tablero(Jugador jugador1, Jugador jugador2) throws VictoriaException {

		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		divisiones = new HashMap<Jugador, LadoDelCampo>();
		LadoDelCampo lado1 = new LadoDelCampo();
		LadoDelCampo lado2 = new LadoDelCampo();
		divisiones.put(jugador1, lado1);
		divisiones.put(jugador2, lado2);
		lado1.guardarMazo(jugador1, jugador2, lado2.obtenerZonaMonstruos(), this);
		lado2.guardarMazo(jugador2, jugador1, lado1.obtenerZonaMonstruos(), this);
	}

	public LadoDelCampo get(Jugador jugador1) {
		return divisiones.get(jugador1);
	}

	public boolean colocarZonaCampo(InvocacionDefault unaInvocacion, Jugador jugador) throws VictoriaException {
		//Si es Wasteland: primero pasar Jugador y después JugadorOponente
		//Si es Sogen: primero pasar JugadorOponente y después Jugador
		unaInvocacion.asignarJugadorACarta(jugador);
		unaInvocacion.asignarTablero(this);
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaCampo(unaInvocacion);
	}

	public Cementerio mostrarCementerio(Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		return ladoDelCampo.mostrarCementerio();
	}

	public boolean colocarZonaTrampaMagica(InvocacionDefault unaInvocacion, Jugador jugador) {
		Carta carta = unaInvocacion.invocar();
		unaInvocacion.asignarTablero(this);
		unaInvocacion.asignarJugadorACarta(jugador);
		jugador.sacarDeMano(carta);
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		this.colocarCementerio(carta, jugador);
		int resul = ladoDelCampo.colocarZonaTrampaMagica(unaInvocacion);
		return resul != -1;
	}

	public int colocarZonaMonstruo(InvocacionCartaMonstruo unaInvocacion, Jugador jugador)
			throws ZonaMonstruoLlenaException, InvocacionExcepcion {
		unaInvocacion.asignarTablero(this);
		unaInvocacion.asignarJugadorACarta(jugador);
		Cementerio cementerio = divisiones.get(jugador).mostrarCementerio();
		ZonaMonstruo zonaMonstruo = divisiones.get(jugador).mostrarZonaMonstruo();
		unaInvocacion.sacrificar(cementerio, zonaMonstruo);
		Carta carta = unaInvocacion.invocar();
		jugador.sacarDeMano(carta);
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaMonstruo(carta);
	}

	public void colocarCementerio(Carta unaCarta, Jugador jugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		ladoDelCampo.colocarCementerio(unaCarta);
	}

	public void atacarDosMonstruos(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo cartaDefensora,
								   Jugador jugadorDefensor) {

		//Activacion de la carta trampa
		if (!divisiones.get(jugadorDefensor).zonaTrampaMagicaEstaVacia()){

				List<CartaTrampa> cartasTrampa = divisiones.get(jugadorDefensor).obtenerTrampas();
				for (CartaTrampa trampa:
					 cartasTrampa) {

					divisiones.get(jugadorDefensor).activarTrampa(trampa, cartaAtacante, jugadorAtacante, cartaDefensora,jugadorDefensor,this);
				    eliminarDeZonaTrampaMagica(trampa, jugadorDefensor);
				    if (!divisiones.get(jugadorAtacante).obtenerMonstruos().contains(cartaAtacante) || trampa.interrumpeAtaque()){
						return;
					}

				}



		}
		//Ejecucion del ataque de dos monstruos
		CartaMonstruo cartaGanadora = cartaAtacante.obtenerGanadoraContra(cartaDefensora);
		Jugador jugadorPerdedor;
		Jugador jugadorGanador;
		CartaMonstruo cartaPerdedora;
		if (cartaDefensora.getEstado().getClass().equals(BocaAbajo.class) && cartaDefensora instanceof Efecto){

				Efecto monstruoConEfectoDeVolteo = (Efecto) cartaDefensora ;
				monstruoConEfectoDeVolteo.activarEfectoDeVolteoAnteAtaque(jugadorDefensor,jugadorAtacante,this);
				if (!divisiones.get(jugadorAtacante).obtenerMonstruos().contains(cartaAtacante)){
					return;
				}



		}
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

		//Caso especial de que ambas modelo.cartas tengan la misma cantidad de puntos de ataque
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
		if(carta instanceof CartaMonstruo){
			divisiones.get(jugador).eliminarDeZonaMonstruo((CartaMonstruo) carta);
		}else{
		divisiones.get(jugador).eliminarDeZonaTrampaMagica(carta);
		}
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

	public List<List<Casillero>> mostrarCasillerosZonaMonstruo() {
		List<List<Casillero>> lista = new ArrayList();
		List<Casillero> lista1 = divisiones.get(jugador1).mostrarCasillerosZonaMonstruo();
		List<Casillero> lista2 = divisiones.get(jugador2).mostrarCasillerosZonaMonstruo();
		lista.add(lista1);
		lista.add(lista2);
		return lista;
	}

	public List<List<Casillero>> mostrarCasillerosZonaCampo() {
		List<List<Casillero>> lista = new ArrayList();
		List<Casillero> lista1 = divisiones.get(jugador1).mostrarCasillerosZonaCampo();
		List<Casillero> lista2 = divisiones.get(jugador2).mostrarCasillerosZonaCampo();
		lista.add(lista1);
		lista.add(lista2);
		return lista;
	}


	public List<List<Casillero>> mostrarCasillerosZonaTrampaMagica() {
		List<List<Casillero>> lista = new ArrayList();
		List<Casillero> lista1 = divisiones.get(jugador1).mostrarCasillerosZonaTrampaMagica();
		List<Casillero> lista2 = divisiones.get(jugador2).mostrarCasillerosZonaTrampaMagica();
		lista.add(lista1);
		lista.add(lista2);
		return lista;
	}

	public Jugador obtenerJugadorOponente(Jugador jugadorDeTurno) {
		for (Object jugador: divisiones.keySet()
			 ) {
			if (jugador instanceof Jugador){
				if (jugador.hashCode()!=jugadorDeTurno.hashCode()){
					return (Jugador) jugador;
				}
			}
		}
		return null;
	}
}