package modelo.cartas.cartasTrampa;

import modelo.cartas.Carta;
import modelo.efectos.EfectoTrampa;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public abstract class CartaTrampa extends Carta {
    private EfectoTrampa efectoTrampaDeLaTrampa;

    public CartaTrampa(String unNombre, EfectoTrampa efectoTrampaDeLaTrampa) {
        super(unNombre);
        this.efectoTrampaDeLaTrampa = efectoTrampaDeLaTrampa;
    }

    public void activarAnteUnAtaque(modelo.cartas.cartasMonstruo.CartaMonstruo cartaAtacante, Jugador atacante, modelo.cartas.cartasMonstruo.CartaMonstruo cartaDefensora,
                                    Jugador jugadorDefensor, Tablero tablero) {
        efectoTrampaDeLaTrampa.activarAnteUnAtaque(cartaAtacante,atacante, cartaDefensora, jugadorDefensor, this, tablero);
    }
    public  boolean interrumpeAtaque(){
         return efectoTrampaDeLaTrampa.interrumpeAtaque();
    }

}
