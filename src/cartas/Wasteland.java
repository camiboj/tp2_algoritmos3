package cartas;

import jugador.Punto;

import java.util.List;

public class Wasteland extends CartaCampo {

    public Wasteland() {
        super("Wasteland");
        puntosAdicionalesAtaque = new Punto(200);
        puntosAdicionalesDefensa = new Punto(300);
    }
}





