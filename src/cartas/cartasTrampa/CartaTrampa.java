package cartas.cartasTrampa;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import efectos.EfectoTrampa;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;

public abstract class CartaTrampa extends Carta {
    private EfectoTrampa efectoTrampaDeLaTrampa;

    public CartaTrampa(String unNombre, EfectoTrampa efectoTrampaDeLaTrampa) {
        super(unNombre);
        this.efectoTrampaDeLaTrampa = efectoTrampaDeLaTrampa;
    }

    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador atacante, CartaMonstruo cartaDefensora, Jugador jugadorDefensor) throws InterrumpirAtaqueException {
        efectoTrampaDeLaTrampa.activarAnteUnAtaque(cartaAtacante,atacante, cartaDefensora, jugadorDefensor, this);
    }
}
