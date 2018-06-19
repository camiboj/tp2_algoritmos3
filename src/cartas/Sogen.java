package cartas;

import jugador.Punto;

public class Sogen extends CartaCampo {

    public Sogen() {
        super("Sogen");
        puntosAdicionalesAtaque = new Punto(200);
        puntosAdicionalesDefensa = new Punto(500);
    }
}
