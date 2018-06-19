package tablero;
import java.util.HashMap;
import java.util.List;

import cartas.*;
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

	public boolean colocarZonaCampo(InvocacionCartaCampo unaInvocacion, Jugador jugador, Jugador jugadorOponente) {
		//Si es Wasteland: primero pasar Jugador y después JugadorOponente
		//Si es Sogen: primero pasar JugadorOponente y después Jugador

		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		LadoDelCampo ladoDelCampoOponente = divisiones.get(jugadorOponente);
		ZonaMonstruo zonaMonstruoJugador = ladoDelCampo.mostrarZonaMonstruo();
        ZonaMonstruo zonaMonstruoJugadorOponente = ladoDelCampoOponente.mostrarZonaMonstruo()    ;
		List<CartaMonstruo> monstruosJugador = zonaMonstruoJugador.obtenerMonstruos();
        List<CartaMonstruo> monstruosJugadorOponente = zonaMonstruoJugadorOponente.obtenerMonstruos();

        return ladoDelCampo.colocarZonaCampo(unaInvocacion, monstruosJugador, monstruosJugadorOponente);
	}

	public Cementerio mostrarCementerio(Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		return ladoDelCampo.mostrarCementerio();
	}
	public boolean colocarZonaTrampaMagica(Invocacion unaInvocacion, Jugador jugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaTrampaMagica(unaInvocacion);
	}

	public boolean colocarZonaMonstruo(InvocacionCartaMonstruo unaInvocacion, Jugador jugador) {
		if (unaInvocacion.debeSacrificar()) {
			List<CartaMonstruo> sacrificios = unaInvocacion.mostrarCartasASacrificar();
			for (CartaMonstruo carta: sacrificios) {
				colocarCementerio(carta, jugador);
				eliminarDeZonaMonstruo(carta, jugador);
			}
		}
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		return ladoDelCampo.colocarZonaMonstruo(unaInvocacion);
	}

	public void colocarCementerio(Carta unaCarta, Jugador jugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(jugador);
		ladoDelCampo.colocarCementerio(unaCarta);
	}

	public void atacarDosMonstruos(CartaMonstruo cartaAtacante, Jugador jugadorAtacante, CartaMonstruo cartaDefensora,
								   Jugador jugadorDefensor) {


		CartaMonstruo cartaGanadora = cartaAtacante.obtenerGanadoraContra(cartaDefensora);
		Jugador jugadorPerdedor;
		Jugador jugadorGanador;
		CartaMonstruo cartaPerdedora;
		if (cartaDefensora == cartaGanadora && cartaDefensora.enModoDefensa()){return;}
		if (cartaGanadora == cartaDefensora) {
			jugadorPerdedor = jugadorAtacante;
			cartaPerdedora = cartaAtacante;
			jugadorGanador = jugadorDefensor;
		}
		else {
			jugadorPerdedor = jugadorDefensor;
			cartaPerdedora = cartaDefensora;
			jugadorGanador = jugadorAtacante;
		}
		colocarCementerio(cartaPerdedora, jugadorPerdedor);
		eliminarDeZonaMonstruo(cartaPerdedora, jugadorPerdedor);
		if (cartaDefensora.enModoDefensa()) {return;}
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

	private void eliminarDeZonaMonstruo(CartaMonstruo unaCarta, Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		ladoDelCampo.eliminarDeZonaMonstruo(unaCarta);
	}

	public ZonaMonstruo mostrarZonaMonstruo(Jugador unJugador) {
		LadoDelCampo ladoDelCampo = divisiones.get(unJugador);
		return ladoDelCampo.mostrarZonaMonstruo();
	}

	public void accionAgujeroNegro() {
        for (LadoDelCampo unLadoDelCampo: divisiones.values()) {
            unLadoDelCampo.efectoAgujeroNegro();
        }
	}

    public boolean noTieneCartasMonstruo() {
        for (LadoDelCampo l: divisiones.values()) {
            if(!l.zonaMonstruoEstaVacia())return false;
        }
        return true;
    }
}