package estadosDeCartas;

import cartas.Carta;

public class BocaArriba implements Estado {

    public void darVuelta(Carta carta) {
        System.out.println("La carta esta boca arriba");
        carta.colocarBocaArriba();
        //las cartas una vez puestas boca arriba no se pueden poner boca abajo de nuevo
    }
}
