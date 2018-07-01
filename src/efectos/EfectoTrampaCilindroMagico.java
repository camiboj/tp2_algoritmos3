package efectos;
import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import tablero.Tablero;

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
