package modelo.estadosDeCartas;

import modelo.jugador.Punto;

public class ModoDeDefensa  extends Modo{

	public ModoDeDefensa(Punto unPunto) {
		super(unPunto);
	}

	public boolean enAtaque(){return false;}
	public boolean enDefensa(){return true;}
	@Override
	public boolean equals(Object object){return this.getClass().equals(object.getClass());}
	
}
