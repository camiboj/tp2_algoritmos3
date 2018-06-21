package cartas.cartasCampo;

import cartas.cartasCampo.CartaCampo;
import jugador.Punto;

public class Wasteland extends CartaCampo {

    public Wasteland() {
        super("Wasteland");
        puntosAdicionalesAtaque = new Punto(200);
        puntosAdicionalesDefensa = new Punto(300);
    }
}





