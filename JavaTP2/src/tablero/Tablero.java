package tablero;
import java.util.HashMap;

import jugador.Jugador;



public class Tablero {
    private HashMap<Jugador, LadoDelCampo> divisiones;

	public Tablero(Jugador jugador1, Jugador jugador2) {
		
		divisiones = new HashMap<Jugador, LadoDelCampo>();
		divisiones.put(jugador1, new LadoDelCampo());
		divisiones.put(jugador2, new LadoDelCampo());
		
	}

	public LadoDelCampo get(Jugador jugador1) {
		// TODO Auto-generated method stub
		return divisiones.get(jugador1);
	}
    
    
    
}
