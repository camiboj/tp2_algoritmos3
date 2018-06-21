package tablero;
import cartas.*;
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
	public boolean equals(Object object){return this.getClass().equals(object.getClass());}

	public LadoDelCampo () {
		miCementerio = new Cementerio();
		miMazo = new Mazo();
		miZonaCampo = new ZonaCampo();
		miZonaDeTrampasYMagia = new ZonaTrampaMagica();
		miZonaMonstruo = new ZonaMonstruo() {
		};
	}

	public Cementerio mostrarCementerio() {
		return miCementerio;
	}

	public boolean colocarZonaTrampaMagica (Invocacion unaInvocacion) {
		return miZonaDeTrampasYMagia.colocarCarta(unaInvocacion);
	}

	public boolean colocarZonaMonstruo (InvocacionCartaMonstruo unaInvocacion) {
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

	public boolean zonaMonstruoEstaVacia(){
		return miZonaMonstruo.estaVacia();
	}

    public boolean colocarZonaCampo(InvocacionCartaCampo unaInvocacion, List<CartaMonstruo> monstruosJugador,
									List<CartaMonstruo> monstruosJugadorOponente) {
		return miZonaCampo.colocarCarta(unaInvocacion, monstruosJugador, monstruosJugadorOponente);
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
                              Jugador jugadorDefensor) throws  InterrumpirAtaqueException{
		miZonaDeTrampasYMagia.activar(trampa, cartaAtacante, jugadorAtacante, cartaDefensora, jugadorDefensor);
	}

    public List<Trampa> obtenerTrampas() {
	    return miZonaDeTrampasYMagia.obtenerCartasTrampas();
    }
    public void eliminarCartaDeZonaMagicaOTrampa(Carta carta) {
        miZonaDeTrampasYMagia.eliminarCarta(carta);

    }
}