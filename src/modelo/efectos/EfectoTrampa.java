package modelo.efectos;


import modelo.cartas.Carta;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public interface EfectoTrampa {
    public void activarAnteUnAtaque(modelo.cartas.cartasMonstruo.CartaMonstruo cartaAtacante, Jugador jugadorAtacante,
                                    modelo.cartas.cartasMonstruo.CartaMonstruo monstruoDefensor, Jugador jugadorDefensor, Carta cartaJugada, Tablero tablero)
            ;
    public  boolean interrumpeAtaque();
}
