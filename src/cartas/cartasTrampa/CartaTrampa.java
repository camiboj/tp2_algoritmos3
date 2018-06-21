package cartas.cartasTrampa;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import efectos.Efecto;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;

public abstract class CartaTrampa extends Carta {
    private Efecto efectoDeLaTrampa;

    public CartaTrampa(String unNombre, Efecto efectoDeLaTrampa) {
        super(unNombre);
        this.efectoDeLaTrampa= efectoDeLaTrampa;
    }

    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador atacante, CartaMonstruo cartaDefensora, Jugador jugadorDefensor) throws InterrumpirAtaqueException {
        efectoDeLaTrampa.activarAnteUnAtaque(cartaAtacante,atacante, cartaDefensora, jugadorDefensor, this);
    }
}
