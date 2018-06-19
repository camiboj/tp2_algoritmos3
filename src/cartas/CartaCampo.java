package cartas;

import jugador.Punto;

import java.util.List;

public class CartaCampo extends Carta {
    Punto puntosAdicionalesAtaque;
    Punto puntosAdicionalesDefensa;

    public CartaCampo(String unNombre) {
        super(unNombre);
    }

    public void activarEfecto(List<CartaMonstruo> cartasEfectoAtaque, List <CartaMonstruo> cartasEfectoDefensa) {
        Punto puntosAtaque = new Punto(200);
        Punto puntosDefensa = new Punto(300);
        for (CartaMonstruo carta : cartasEfectoDefensa) {
            carta.aumentarDefensa(puntosDefensa);
        }
        for (CartaMonstruo carta : cartasEfectoAtaque) {
            if (carta == null) System.out.println("CACA");
            carta.aumentarAtaque(puntosAtaque);
        }

    }
}
