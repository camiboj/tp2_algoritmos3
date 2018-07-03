package modelo.efectos;
import modelo.cartas.Carta;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public class EfectoTrampaCilindroMagico implements EfectoTrampa {

    public void activarAnteUnAtaque(modelo.cartas.cartasMonstruo.CartaMonstruo cartaAtacante, Jugador jugadorAtacante,
                                    modelo.cartas.cartasMonstruo.CartaMonstruo monstruoDefensor, Jugador jugadorDefensor, Carta cartaJugada, Tablero tablero)
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
