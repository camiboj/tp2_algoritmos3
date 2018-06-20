package tablero;
import cartas.*;

import java.util.List;

public class ZonaCampo { //Le saque la interfaz porque no coloca una carta cualquiera, esa carta activa efecto
    private Casillero casillero; //Ceci: entiendo que hay una carta en el tablero

    public ZonaCampo() {
        casillero = new Casillero();
    }

        public boolean colocarCarta(InvocacionCartaCampo invocacion, List<CartaMonstruo> monstruosJugador,
                                    List<CartaMonstruo> monstruosJugadorOponente) {
        //Devuelve true si pudo colocarla y false si la zona estaba completa
        if (casillero.estaVacio()) {
            CartaCampo carta = invocacion.invocar();
            carta.activarEfecto(monstruosJugador, monstruosJugadorOponente);
            casillero.colocarCarta(carta);
            return true;
        }
        return false;
    }

    public void eliminarCarta(Carta carta) {
        return;
    }
}
