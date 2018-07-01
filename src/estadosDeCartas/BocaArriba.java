package estadosDeCartas;

import cartas.Carta;
import excepciones.VictoriaException;

public class BocaArriba implements Estado  {

    public void darVuelta(Carta carta) throws VictoriaException {
        System.out.println("La carta esta boca arriba");
        carta.colocarBocaArriba();
        //las cartas una vez puestas boca arriba no se pueden poner boca abajo de nuevo
    }
}
