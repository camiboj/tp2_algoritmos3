package modelo.efectos;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public class EfectoTrampaCilindroMagico implements EfectoTrampa {

    public void activarAnteUnAtaque(CartaMonstruo cartaAtacante, Jugador jugadorAtacante,
                                    CartaMonstruo monstruoDefensor, Jugador jugadorDefensor, Carta cartaJugada, Tablero tablero)
            {
        jugadorAtacante.restarPuntos(cartaAtacante.obtenerPuntosAtaque());
        tablero.colocarCementerio(cartaJugada,jugadorDefensor);
        tablero.mostrarZonaTrampaMagica(jugadorDefensor).eliminarCarta(cartaJugada);

    }

    @Override
    public boolean interrumpeAtaque() {
        return true;
    }


}
