package modelo.cartas;
import modelo.estadosDeCartas.BocaAbajo;
import modelo.estadosDeCartas.BocaArriba;
import modelo.estadosDeCartas.Estado;
import modelo.excepciones.VictoriaException;

public abstract class Carta {
    protected String nombre;
    private Estado estado;
    
    
    public Carta(String unNombre) {
        this.nombre = unNombre;
        this.estado = null;
    }

    public void colocarBocaArriba() throws  VictoriaException {
        this.estado = new BocaArriba();
        this.activarEfecto();
    }

    public abstract void activarEfecto() throws VictoriaException;

    public void colocarBocaAbajo() {
    	this.estado = new BocaAbajo();
	}

	public Estado getEstado() {
		return estado;
	}

    public boolean equals(Object object){return this.getClass().equals(object.getClass());}

    public String getNombre(){
        return nombre;
    }
}