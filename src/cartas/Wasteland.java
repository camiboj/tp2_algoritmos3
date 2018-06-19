package cartas;

import jugador.Punto;

import java.util.List;

public class Wasteland extends CartaCampo {

    public Wasteland() {
        super("Wasteland");
        puntosAdicionalesAtaque = new Punto(200);
        puntosAdicionalesDefensa = new Punto(300);
    }
    /*
    public void activarEfecto(List <CartaMonstruo> cartasEfectoAtaque, List <CartaMonstruo> cartasEfectoDefensa) {
       Punto puntosAtaque = new Punto(200);
       Punto puntosDefensa = new Punto(300);
        for (CartaMonstruo carta : cartasEfectoAtaque) {
            carta.aumentarAtaque(puntosAtaque);
        }
        for (CartaMonstruo carta : cartasEfectoDefensa) {
            carta.aumentarDefensa(puntosDefensa);
        }
    }
    */
}





