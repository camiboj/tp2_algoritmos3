package modelo.efectos;


import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public interface EfectoTrampa {
    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante,
                                    CartaMonstruo monstruoDefensor, Jugador jugadorDefensor, Carta cartaJugada, Tablero tablero)
            ;
    public  boolean interrumpeAtaque();
}
