package tablero;
import jugador.Mazo;

public class LadoDelCampo {
	private Cementerio miCementerio;
	private Mazo miMazo;
	private ZonaCampo miZonaCampo;
	private ZonaTrampaMagica miZonaDeTrampasYMagia;
	private ZonaMonstruo miZonaMonstruo;
	
	@Override
	public boolean equals(Object object){return this.getClass().equals(object.getClass());}
	
}
