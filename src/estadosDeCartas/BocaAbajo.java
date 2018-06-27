package estadosDeCartas;
import cartas.Carta;
import excepciones.VictoriaException;
import tablero.InterrumpirAtaqueException;

public class BocaAbajo implements Estado {

    public void darVuelta(Carta carta) throws InterrumpirAtaqueException, VictoriaException {
        System.out.println("La carta esta boca abajo");
        //carta.setEstado(this);
        carta.colocarBocaArriba();
    }

	@Override
	public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
