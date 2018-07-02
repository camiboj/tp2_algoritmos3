package modelo.estadosDeCartas;
import modelo.jugador.Punto;

public class ModoDeAtaque extends Modo{
	private Punto punto;

	public ModoDeAtaque(Punto unPunto) {
		super(unPunto);
	}

	public boolean enAtaque(){return true;}
	public boolean enDefensa(){return false;}

	public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
