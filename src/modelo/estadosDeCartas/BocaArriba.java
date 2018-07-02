package modelo.estadosDeCartas;

import modelo.cartas.Carta;
import modelo.excepciones.VictoriaException;

public class BocaArriba implements Estado  {

    public void darVuelta(Carta carta) throws VictoriaException {
        System.out.println("La carta esta boca arriba");
        carta.colocarBocaArriba();
        //las modelo.cartas una vez puestas boca arriba no se pueden poner boca abajo de nuevo
    }
}
