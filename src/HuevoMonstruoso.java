public class HuevoMonstruoso {
    private estadosDeCartas.Modo modo;

	public Object getUbicacion() {
        return new Cementerio();
    }
	private void cambiarEstado(estadosDeCartas.Modo m) {
		this.modo= m;
	}
    public void atacar(AgujeroNegro agujeroNegro) {
    }

	public void invocar() {
		// TODO Auto-generated method stub
		
	}

	public void modoDeAtaque() {
		// TODO Auto-generated method stub
		 cambiarEstado(new ModoDeAtaque());
	}

	public Object modo() {
		// TODO Auto-generated method stub
		return modo;
	}

	public void modoDeDefensa() {
		cambiarEstado(new ModoDeDefensa());
	}
}
