package cartas;
import estadosDeCartas.BocaAbajo;
import estadosDeCartas.BocaArriba;
import estadosDeCartas.Estado;

public abstract class Carta {
    protected String nombre;
    private Estado estado;
    
    
    public Carta(String unNombre) {
        this.nombre = unNombre;
        this.estado = null;
    }

    public void colocarBocaArriba(){
        this.estado = new BocaArriba();
        this.activarEfecto();
    }

    public void activarEfecto() {
    }

    public void colocarBocaAbajo() {
    	this.estado = new BocaAbajo();
	}
	public Estado getEstado() {
		return estado;
	}

    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
