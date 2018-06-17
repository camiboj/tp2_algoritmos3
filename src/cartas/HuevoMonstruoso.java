package cartas;
import efectos.AgujeroNegro;
import estadosDeCartas.Modo;
import estadosDeCartas.ModoDeAtaque;
import estadosDeCartas.ModoDeDefensa;
import tablero.Cementerio;

public class HuevoMonstruoso {
    private Modo modo;

	public Object getUbicacion() {
        return new Cementerio();
    }
	private void cambiarEstado(Modo m) {
		this.modo= m;
	}
    public void atacar(AgujeroNegro agujeroNegro) {
    }

	public void invocar() {
	}

	public void modoDeAtaque() {
		 cambiarEstado(new ModoDeAtaque());
	}

	public Object modo() {
		return modo;
	}

	public void modoDeDefensa() {
		cambiarEstado(new ModoDeDefensa());
	}
}
