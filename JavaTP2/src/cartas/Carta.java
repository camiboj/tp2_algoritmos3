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
    }
    public void colocarBocaAbajo() {
    	this.estado = new BocaAbajo();
	}


	public Estado getEstado() {
		// TODO Auto-generated method stub
		return estado;
	}


    /*public Carta crearCarta(char unNombre) {
        Carta resultado = new Carta(unNombre);
        return resultado;
    }*/
}
