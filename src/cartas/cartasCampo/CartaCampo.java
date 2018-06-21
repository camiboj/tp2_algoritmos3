package cartas.cartasCampo;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Punto;

import java.util.List;

public class CartaCampo extends Carta {
    Punto puntosAdicionalesAtaque;
    Punto puntosAdicionalesDefensa;

    public CartaCampo(String unNombre) {
        super(unNombre);
    }

    public void activarEfecto(List<CartaMonstruo> cartasEfectoAtaque, List <CartaMonstruo> cartasEfectoDefensa) {

        for (CartaMonstruo carta : cartasEfectoDefensa) {
            carta.aumentarDefensa(puntosAdicionalesDefensa);
        }
        for (CartaMonstruo carta : cartasEfectoAtaque) {
            carta.aumentarAtaque(puntosAdicionalesAtaque);
        }
    }
}
