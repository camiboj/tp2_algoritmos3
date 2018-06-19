package cartas;;
import estadosDeCartas.Modo;
import jugador.Punto;
import tablero.Cementerio;
import cartas.CartaMonstruo;

public class HuevoMonstruoso extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
	//efecto

	public HuevoMonstruoso() {
		super("Huevo Monstruoso", 600, 900, 3);
		modo = null;
	}

	public Object getUbicacion() {
        return new Cementerio();
    }
	public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
